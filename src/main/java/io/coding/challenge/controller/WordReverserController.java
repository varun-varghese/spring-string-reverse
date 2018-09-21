package io.coding.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.coding.challenge.service.WordReverserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WordReverserController {
	
	@Autowired
	private WordReverserService wordReverserService;
	
	@RequestMapping(
			value = "/reverse", 
			method = {RequestMethod.GET, RequestMethod.POST},
			headers = "Accept=application/json",
			produces = "application/json")
	@ResponseBody
	String reverse(@RequestBody String input) {
		log.debug("| Received {} for reversing", input);
		return wordReverserService.reverse(input);
	}

}
