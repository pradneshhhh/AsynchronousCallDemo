package com.async.demo.AsynchronousCallDemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.demo.AsynchronousCallDemo.service.AsyncService;

@RestController
public class AsyncController {

	@Autowired
	AsyncService service;

	@GetMapping(value = "ping/async")
	public ResponseEntity<Map<String, String>> processAsync() {
		Map<String, String> resp = new HashMap<String, String>();
		service.process();
		resp.put("message", "Process initiated...");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
