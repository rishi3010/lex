package com.guardian.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guardian.bean.BotResponse;

@Service
public class LexService {

	@Value("${aws.lex.bot.name}")
	private String botName;

	@Value("${aws.lex.bot.alias}")
	private String botAlias;

	public void getLexResponse() throws JsonMappingException, JsonProcessingException {
		AmazonLexRuntime client = AmazonLexRuntimeClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		PostTextRequest textRequest = new PostTextRequest();
		textRequest.setBotName(botName);
		textRequest.setBotAlias(botAlias);
		textRequest.setUserId("testuser");
		String requestText = "Start build of cmt dev";

		textRequest.setInputText(requestText);
		PostTextResult textResult = client.postText(textRequest);
		if (textResult.getDialogState().equals("Fulfilled")) {
			BotResponse reponse = new ObjectMapper().readValue(textResult.getMessage(), BotResponse.class);

		}
	}
}