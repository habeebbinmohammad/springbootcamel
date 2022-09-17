package com.enterspacetech.foocamelspringboot.components;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleTimer extends RouteBuilder {
    @Override
    public void configure() throws Exception {


        from("timer:simpleFootimer?period=2000")
                .routeId("mysimplerouteId")
                .setBody( constant("Helloworld"))
                .log( LoggingLevel.INFO,"${body");
    }
}
