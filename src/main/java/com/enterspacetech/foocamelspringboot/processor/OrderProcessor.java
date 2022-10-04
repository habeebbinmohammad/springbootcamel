package com.enterspacetech.foocamelspringboot.processor;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor implements org.apache.camel.Processor {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void process(Exchange exchange) throws Exception {
        String fileData= exchange.getIn().getBody(String.class);
        logger.info( "This is read from fileData"+ fileData);
    }
}
