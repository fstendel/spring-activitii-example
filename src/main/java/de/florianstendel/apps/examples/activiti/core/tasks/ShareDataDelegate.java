package de.florianstendel.apps.examples.activiti.core.tasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShareDataDelegate implements JavaDelegate {

    private Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution delegateExecution) {

        String fetchedData = delegateExecution.getVariable("FetchedDataVar", String.class);
        _logger.info("Alrighty then, share the data: " + fetchedData);
        // Do some calls for store the data here (e.g. REST-call to a service)
        _logger.info("Wohoo, data has been writen to the data share");

    }
}
