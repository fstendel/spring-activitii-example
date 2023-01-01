package de.florianstendel.apps.examples.activiti.web.ui.models;

import org.activiti.engine.repository.ProcessDefinition;

public class ProcessDetail {

    private String processKey;

    public ProcessDetail(final ProcessDefinition processDefinition) {

        this.processKey = processDefinition.getKey();
    }

    public String getProcessKey(){
        return this.processKey;
    }
}
