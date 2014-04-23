package com.bisnode.jersey.demo;

import com.bisnode.jersey.demo.config.MyConfig
import groovy.util.logging.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * Web application starter
 *
 * Date: 22/12/13
 * Time: 18:03
 *
 * @author Joakim Sundqvist
 */
@Slf4j
class Application {

    static void main(String[] args) throws Exception {
        log.info("Starting Spring boot")
        new SpringApplicationBuilder(MyConfig.class)
                .showBanner(false)
                .run(args)
    }
}
