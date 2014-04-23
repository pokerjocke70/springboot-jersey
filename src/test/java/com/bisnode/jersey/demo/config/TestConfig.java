package com.bisnode.jersey.demo.config;

import com.bisnode.jersey.demo.rest.RestResource;
import com.bisnode.jersey.demo.service.MessageService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 31/01/2014
 * Time: 00:41
 *
 * @author Geoffroy Warin (http://bisnode.github.io)
 */
@Configuration
@ComponentScan(basePackageClasses = {RestResource.class, MessageService.class})
public class TestConfig {
}
