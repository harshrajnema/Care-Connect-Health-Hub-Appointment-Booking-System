package common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 
public class DateStringDeserializer extends JsonDeserializer<Date> {
	
 
	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
			throws IOException, JsonProcessingException {
		String str = paramJsonParser.getText().trim();

		try {
 			DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
			if("".equals(str) || null== str || "null"== str) {
				return null;
			}
			Date fDate = originalFormat.parse(str);
 			return fDate;
		} catch (ParseException e) {
 		}
		return paramDeserializationContext.parseDate(str);
	}

}