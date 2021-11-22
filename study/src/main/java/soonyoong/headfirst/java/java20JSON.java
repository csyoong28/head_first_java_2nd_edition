package soonyoong.headfirst.java;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class java20JSON {
	public static void main(String args[]) throws JsonMappingException, JsonProcessingException {
	    String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode actualObj = mapper.readTree(jsonString);
	    int x=1;

	    
	}
}
