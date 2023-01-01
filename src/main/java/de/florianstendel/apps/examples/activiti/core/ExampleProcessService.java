package de.florianstendel.apps.examples.activiti.core;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExampleProcessService {

    private Logger _logger = LoggerFactory.getLogger(this.getClass());

    private RuntimeService runtimeService;

    @Autowired
    public ExampleProcessService(final RepositoryService repositoryService,
                                 final RuntimeService runtimeService) {

        this.runtimeService = runtimeService;

        repositoryService.createDeployment()
                .addClasspathResource("processes/simpleNewsReport.bpmn20.xml")
                .deploy();
        repositoryService.createDeployment()
                .addClasspathResource("processes/extendedNewsReport.bpmn20.xml")
                .deploy();

    }

    public void handleNotificationProcessIngest(final String url, final String emailAddress) {

        Map<String,Object> passedVariables = new HashMap<>();
        passedVariables.put("UrlToFetch", url);
        passedVariables.put("NotifiedUserEmail",emailAddress);

        _logger.info("Starting process with input variables: "+url);

        runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey("NewsReportProcess")
                .variables(passedVariables)
                .businessKey("News-Report-"+ System.currentTimeMillis())
                .start();
    }

}



