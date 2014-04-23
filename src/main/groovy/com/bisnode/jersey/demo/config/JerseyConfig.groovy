package com.bisnode.jersey.demo.config

import groovy.transform.CompileStatic
import org.glassfish.jersey.filter.LoggingFilter
import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.scope.RequestContextFilter

@CompileStatic
class JerseyConfig extends ResourceConfig {

    static final String LOCAL = "local"

    JerseyConfig() {
        register(RequestContextFilter.class)
        register(JacksonFeature.class)
        packages("com.bisnode.jersey.demo.rest")
        if (LOCAL.equals(System.getProperty("solinfra.level", LOCAL))) {
            register(LoggingFilter.class)
        }
    }
}