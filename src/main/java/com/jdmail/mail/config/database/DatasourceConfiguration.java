package com.jdmail.mail.config.database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {
    private static Logger LOGGER = LoggerFactory.getLogger(DatasourceConfiguration.class);


}
