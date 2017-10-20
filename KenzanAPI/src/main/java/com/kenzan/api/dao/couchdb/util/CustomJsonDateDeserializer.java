package com.kenzan.api.dao.couchdb.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonDeserializer;


public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
   
	@Override
	public Date deserialize(JsonParser jsonparser, org.codehaus.jackson.map.DeserializationContext arg1)
			throws IOException, org.codehaus.jackson.JsonProcessingException {
		  SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	        String date = jsonparser.getText();
	        try {
	            return format.parse(date);
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }
	}

}