package de.florianstendel.apps.examples.activiti.web.ui.mappers;

import de.florianstendel.apps.examples.activiti.web.ui.models.ExecutionDetail;
import org.activiti.engine.history.HistoricProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExecutionDetailsMapper {

    private static final Logger _logger = LoggerFactory.getLogger(ExecutionDetailsMapper.class);

    public static List<ExecutionDetail> map(List<HistoricProcessInstance> historyRecords) {

        _logger.info("Map process history records (size:"+historyRecords.size()+")");

        List<ExecutionDetail> historyModels = new ArrayList<>();

        for (HistoricProcessInstance historyRecord: historyRecords) {
            historyModels.add(new ExecutionDetail(historyRecord));
        }
        return historyModels;
    }
}
