package de.florianstendel.apps.examples.activiti;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ActivitiConfiguration {

    @Autowired
    DataSource dataSource;

    @Bean
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        SpringProcessEngineConfiguration res = new SpringProcessEngineConfiguration();
        res.setDataSource(dataSource);
        res.setTransactionManager(getTransactionManager());
        res.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
        return res;
    }

    @Bean
    public ProcessEngineFactoryBean getProcessEngine() {
        ProcessEngineFactoryBean res = new ProcessEngineFactoryBean();
        res.setProcessEngineConfiguration(getProcessEngineConfiguration());
        return res;
    }

    @Bean
    public RepositoryService getRepositoryService() throws Exception {
        return getProcessEngine().getObject().getRepositoryService();
    }

    @Bean
    public TaskService getTaskService() throws Exception {
        return getProcessEngine().getObject().getTaskService();
    }

    @Bean
    public RuntimeService getRuntimeService() throws Exception {
        return getProcessEngine().getObject().getRuntimeService();
    }

    @Bean
    public HistoryService getHistoryService() throws Exception {
        return getProcessEngine().getObject().getHistoryService();
    }
}