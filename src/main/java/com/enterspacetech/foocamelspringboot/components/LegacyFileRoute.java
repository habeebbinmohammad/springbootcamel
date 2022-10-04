package com.enterspacetech.foocamelspringboot.components;

import com.enterspacetech.foocamelspringboot.processor.OrderProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LegacyFileRoute  extends RouteBuilder {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void configure() throws Exception {

        from("file:src/data/input?fileName=inputFileName.txt")
                .routeId("legacyRouteID")
                .process( new OrderProcessor())
                .to("file:src/data/output?fileName=outPutFileName.txt");


    }
}
