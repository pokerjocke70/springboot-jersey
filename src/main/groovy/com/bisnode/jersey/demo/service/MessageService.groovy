package com.bisnode.jersey.demo.service

import com.bisnode.jersey.demo.domain.Message

import javax.annotation.PostConstruct
import javax.inject.Named
import javax.inject.Singleton

/**
 * Date: 31/01/2014
 * Time: 02:11
 *
 * @author Geoffroy Warin (http://bisnode.github.io)
 */
@Singleton
@Named
public class MessageService {
    List<Message> messages = Collections.synchronizedList(new ArrayList<Message>())

    @PostConstruct
    public void init() {
        messages.add(new Message(author: "Joe", contents: "Hello"))
        messages.add(new Message(author: "Jane", contents: "Spring boot is cool !"))
    }

    public List<Message> getMessages() {
        messages
    }
}
