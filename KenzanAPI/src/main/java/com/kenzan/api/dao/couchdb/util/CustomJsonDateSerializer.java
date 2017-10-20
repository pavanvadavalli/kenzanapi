package com.kenzan.api.dao.couchdb.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


public class CustomJsonDateSerializer extends JsonSerializer<Date>{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
   
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)

	throws IOException, JsonProcessingException {

	String formattedDate = dateFormat.format(date);

	gen.writeString(formattedDate);

	}

}