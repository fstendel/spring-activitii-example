package de.florianstendel.apps.examples.activiti.web.api;

import de.florianstendel.apps.examples.activiti.core.ExampleProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcessApiController {

    private Logger _logger = LoggerFactory.getLogger(this.getClass());

    private ExampleProcessService exampleProcessService;

    @Autowired
    public ProcessApiController(final ExampleProcessService exampleProcessService){
        this.exampleProcessService = exampleProcessService;
    }


    @PostMapping(value = "/startProcess")
    public void startProcess(@RequestBody StartProcessEntity startProcessEntity) {
        _logger.info("Startprocess called with "+startProcessEntity.getUrl() + " & " +startProcessEntity.getNotificalEmailAdress());

        this.exampleProcessService.handleNotificationProcessIngest(
                startProcessEntity.getUrl(),
                startProcessEntity.getNotificalEmailAdress()
        );
    }
}
