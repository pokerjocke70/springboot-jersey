package com.bisnode.jersey.demo.rest

import com.bisnode.jersey.demo.domain.Message
import com.bisnode.jersey.demo.service.MessageService
import groovy.util.logging.Slf4j

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
@Named
@Singleton
@Slf4j
class RestResource {


    private final MessageService messageService

    @Inject
    public RestResource(MessageService messageService) {
        this.messageService = messageService
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    String hello() {
        "Hello World"
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/messages")
    List<Message> message() {
        messageService.getMessages()
    }
}
