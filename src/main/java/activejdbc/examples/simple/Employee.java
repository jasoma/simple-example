package activejdbc.examples.simple;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.javalite.activejdbc.Model;

import java.io.IOException;

@JsonSerialize(using = Employee.Serializer.class)
public class Employee extends Model {
    static{
        validatePresenceOf("first_name", "last_name");
    }

    public static class Serializer extends JsonSerializer<Employee> {
        @Override
        public void serialize(Employee value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            gen.writeRawValue(value.toJson(false));
        }
    }

}
