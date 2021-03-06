package com.login.flock.demo.controller;

import javax.persistence.Entity;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Entity
public class LoggingController {
Logger logger = (Logger) LoggerFactory.getLogger(LoggingController.class);

	    @RequestMapping("/loger")
	    public String index() {
	        logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");

	        return "Howdy! Check out the Logs to see the output...";
	    }
	}


