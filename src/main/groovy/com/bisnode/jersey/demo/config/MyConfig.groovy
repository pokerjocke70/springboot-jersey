package com.bisnode.jersey.demo.config

import org.glassfish.jersey.servlet.ServletContainer
import org.glassfish.jersey.servlet.ServletProperties
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

/**
 *
 * @author Joakim Sundqvist
 * @since 22/04/14
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.bisnode.jersey.demo")
class MyConfig {


    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*")
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName())
        registration
    }

}
