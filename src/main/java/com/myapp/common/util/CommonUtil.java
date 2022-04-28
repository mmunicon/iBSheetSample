package com.myapp.common.util;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CommonUtil {		
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
		
	public String resultListToJson(List<?> list) {
		String rtnJson = "";		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			hashMap.put("Data", list); // Grid data
			rtnJson = objectMapper.writeValueAsString(hashMap);			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} 
		
		return rtnJson;		
	}
}
