package de.florianstendel.apps.examples.activiti.web.ui.mappers;

import de.florianstendel.apps.examples.activiti.web.ui.models.ProcessDetail;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ProcessDetailsMapper {

    private static final Logger _logger = LoggerFactory.getLogger(ProcessDetailsMapper.class);

    public static List<ProcessDetail> map(List<ProcessDefinition> processDefinitions) {

        _logger.info("Map process details (size: " + processDefinitions.size() + ")");

        List<ProcessDetail> processDetails = new ArrayList<>();
        for (ProcessDefinition processDefinition: processDefinitions) {
            processDetails.add(new ProcessDetail(processDefinition));
        }
        return processDetails;
    }
}
