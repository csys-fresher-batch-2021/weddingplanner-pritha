package in.pritha.util;

import java.lang.reflect.Type;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalTimeAdapter implements JsonSerializer<LocalTime> {
	private LocalTimeAdapter() {
		
	}
	 
		public JsonElement serialize(LocalTime localTime, Type type, JsonSerializationContext jsonSerializationContext) {
			return new JsonPrimitive(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		}

}
