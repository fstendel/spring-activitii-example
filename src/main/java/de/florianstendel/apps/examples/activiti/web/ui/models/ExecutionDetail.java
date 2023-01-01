package de.florianstendel.apps.examples.activiti.web.ui.models;

import org.activiti.engine.history.HistoricProcessInstance;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class ExecutionDetail {


    private String processName;

    private Map<String, Object> processVariables;

    private long duration;

    private LocalDateTime processStart;

    private LocalDateTime processEnd;

    public ExecutionDetail(final HistoricProcessInstance procHistRecord){
        this.duration = procHistRecord.getDurationInMillis();
        this.processName = procHistRecord.getBusinessKey();
        this.processStart = convertToLocalDateTime(procHistRecord.getStartTime());
        this.processEnd = convertToLocalDateTime(procHistRecord.getEndTime());
        this.processVariables = procHistRecord.getProcessVariables();
    }

    private static LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public long getDuration() {
        return this.duration;
    }

    public String getProcessName() {
        return this.processName;
    }

    public Map<String, Object> getProcessVariables() {
        return this.processVariables;
    }

    public LocalDateTime getProcessStart() {
        return this.processStart;
    }

    public LocalDateTime getProcessEnd() {
        return this.processEnd;
    }
}
