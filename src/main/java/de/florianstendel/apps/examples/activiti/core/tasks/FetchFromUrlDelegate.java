package de.florianstendel.apps.examples.activiti.core.tasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchFromUrlDelegate implements JavaDelegate {

    private Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String inputValue = (String) delegateExecution.getVariable("UrlToFetch");

        // Do some calls for fetching the data here (e.g. REST-call to a service)
        _logger.info("Hey, I just fetched some news from: "+inputValue);

        String dummyFetchedData = "[DataFetchedFrom: " + inputValue+"]";
        delegateExecution.setVariable("FetchedDataVar", dummyFetchedData);
    }
}
