package com.async.demo.AsynchronousCallDemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

	@Async("processExecutor")
	public void process() {
		logger.info("Received request to process in AsyncService.process()");
		try {
			Thread.sleep(15 * 1000);
			logger.info("Processing complete...");
		} catch (InterruptedException ie) {
			logger.error("Error in AsyncService.process(): {}", ie.getMessage());
		}
	}

}
