package com.bisnode.jersey.demo.domain

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Date: 31/01/2014
 * Time: 00:33
 *
 * @author Geoffroy Warin (http://bisnode.github.io)
 */
@XmlRootElement
@CompileStatic
@TupleConstructor
class Message {


    @XmlElement
    private String author

    @XmlElement
    private String contents

}