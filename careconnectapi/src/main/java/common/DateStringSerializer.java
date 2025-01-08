package common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

  
public class DateStringSerializer extends JsonSerializer<Date> {
     @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if (value != null) {        
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formatted = sdf.format(value);
             gen.writeString(formatted);
        }else {
         }
    }
 
}