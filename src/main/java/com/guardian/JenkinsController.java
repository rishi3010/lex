package com.guardian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.guardian.service.LexService;

@RestController
@RequestMapping(path = "/lex")
public class JenkinsController {

	@Autowired
	LexService lexService;

	@GetMapping(path = "/connect")
	public void sendTeamsMessage() throws JsonMappingException, JsonProcessingException {
		lexService.getLexResponse();
	}

	@GetMapping(path = "/test")
	public String testMessage() {
		return "test successfull";
	}
}
