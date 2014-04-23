import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import ch.qos.logback.core.status.OnConsoleStatusListener
import ch.qos.logback.classic.AsyncAppender

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.*

/**
 * Logback groovy config - To make it more dynamic
 *
 * @author Joakim Sundqvist
 */
def appName = 'spring-boot-demo'

statusListener(OnConsoleStatusListener)

jmxConfigurator(appName)

def local = System.getProperty('solinfra.level', 'local') == 'local'

def logDir = System.getProperty('solinfra.logdir', '/tmp')

def frameworkLogLevel = local ? INFO : WARN


def fileAppender = null

appender("FILE", RollingFileAppender) {
    file = "${logDir}/${appName}/${appName}.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${logDir}/${appName}/${appName}-%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName("UTF-8")
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n"
    }
    fileAppender = component
}

def consoleAppender = null

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName("UTF-8")
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n"
    }
    consoleAppender = component
}

appender("ASYNC", AsyncAppender){
    component.addAppender(local ? consoleAppender : fileAppender)
}



logger("com.bisnode", local ? DEBUG : INFO)
logger("org.springframework", frameworkLogLevel)

root(WARN, ['ASYNC'])