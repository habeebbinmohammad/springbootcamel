package com.enterspacetech.foocamelspringboot.components;

import com.enterspacetech.foocamelspringboot.processor.OrderProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LegacyCSVFileRoute extends RouteBuilder {

    Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public void configure() throws Exception {


        from ("file:src/data/input?fileName=OrderDetails.csv")
                .routeId("orderRouteID")
                .split(body().tokenize("\n", 1,true) )
                    .process(new OrderProcessor())
                .end()
                .to("file:src/data/output?fileName=ProcessedOrderDetails.csv");


    }
}
