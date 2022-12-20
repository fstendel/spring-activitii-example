# spring-activitii-example

As I run a process engine to consolidate my daily news sources into a more easy to 'consume' form, some of my friends asked me if I could share a very basic setup so they can start similar things.
This spring process flow applications runs a single bpmn2.0 process with the Activiti framework. 
Each task within in the process delegates the implementation of the actual behaviour to a plain java class.
(Where people can just implement their own logic)

## Usage

1. Build with 'mvn clean package'
2. Execute the generated jar in the 'target'-folder
3. Use curl or postman to call 'http://localhost:8080/startProcess' via a POST request and a payload similar to this: `{
    "url":"https://seven.one",
    "notificalEmailAdress":"florian.stendel@localhost.io"
}`
4. You'll then see some log-messages outlining the execution of the process
5. Happy coding!! :)

## What's missing

Due to the fact that the activiti-spring-integration seems to be messy with Spring Boot 3+, I instantiated the relevant beans programmatically.
Therefore, in its current state, Spring managed beans cannot by injected into the delegate-classes.
Will update as soon as I find time. :-)
