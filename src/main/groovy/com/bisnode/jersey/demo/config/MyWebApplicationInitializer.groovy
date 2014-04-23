package com.bisnode.jersey.demo.config

import groovy.transform.CompileStatic
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer

/**
 *
 * @author Joakim Sundqvist
 * @since 22/04/14
 */
@CompileStatic
class MyWebApplicationInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(MyConfig)
    }

}
