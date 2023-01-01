package de.florianstendel.apps.examples.activiti.web.ui;

import de.florianstendel.apps.examples.activiti.web.ui.mappers.ExecutionDetailsMapper;
import de.florianstendel.apps.examples.activiti.web.ui.mappers.ProcessDetailsMapper;
import de.florianstendel.apps.examples.activiti.web.ui.models.ExecutionDetail;
import de.florianstendel.apps.examples.activiti.web.ui.models.ProcessDetail;
import jakarta.servlet.http.HttpServletRequest;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class MonitoringController {

    private Logger _logger = LoggerFactory.getLogger(this.getClass());

    private HistoryService historyService;

    private RepositoryService repositoryService;

    @Autowired
    public MonitoringController(final HistoryService historyService, final RepositoryService repositoryService){
        this.historyService = historyService;
        this.repositoryService = repositoryService;
    }

    @GetMapping(value = "/ui")
    public ModelAndView getUI(@RequestParam(name = "processKey", defaultValue = "") Optional<String> processKey) {

        _logger.info("Generate process overview ");
        ModelAndView modelAndView = new ModelAndView("monitoring-template");

        List<ProcessDetail> processDetails = createProcessDetailsModel();
        modelAndView.addObject("ProcessDefinitions", processDetails);

        if(processKey.isPresent()) {
            List<ExecutionDetail> historyModels = createExecutionHistoryModel(processKey.get());
            modelAndView.addObject("ExecutionHistory", historyModels);
        }
        return modelAndView;
    }

    private List<ProcessDetail> createProcessDetailsModel() {

        List<ProcessDefinition> processDefinitions = this.repositoryService.createProcessDefinitionQuery()
                .active()
                .orderByDeploymentId()
                .asc()
                .list();

        return ProcessDetailsMapper.map(processDefinitions);
    }


    private List<ExecutionDetail> createExecutionHistoryModel(String processKey) {

        List<HistoricProcessInstance> historyRecords = this.historyService.createHistoricProcessInstanceQuery()
                .includeProcessVariables()
                .orderByProcessInstanceStartTime()
                .processDefinitionKey(processKey)
                .asc()
                .list();

        return ExecutionDetailsMapper.map(historyRecords);
    }
}
