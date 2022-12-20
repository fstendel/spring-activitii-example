package de.florianstendel.apps.examples.activiti.core.tasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotifiyUserDelegate implements JavaDelegate {

    private Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution delegateExecution) {

        String inputValue = delegateExecution.getVariable("UrlToFetch", String.class);
        String userEmail = delegateExecution.getVariable("NotifiedUserEmail", String.class);

        _logger.info("Will tell user with email: "+userEmail+" about data fetched from: "+inputValue);

        // Do something to notify user here, e.g. sending email (a.k.a. fire-and-forget)

        _logger.info("User notified, let's hope he reads his emails");
    }
}
