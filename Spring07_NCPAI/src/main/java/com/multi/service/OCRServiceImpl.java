package com.multi.service;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:apiKey.properties")
public class OCRServiceImpl implements OCRService {

	
	@Value("${secretKey}")
	private String secretKey;
	
	@Value("${apiUrl}")
	private String apiUrl;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public String extractTextFromImage(String filePath) {
		//----------------------------------------------------
		
		//----------------------------------------------------
		return null;
	}

}
