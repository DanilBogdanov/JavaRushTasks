package Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Test {
    public static void main(String[] args) throws IOException {

        StringWriter stringWriter = new StringWriter();
        Cat cat = new Cat("Chip", 1, 5);


        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(stringWriter,cat);
        String result = stringWriter.toString();
        System.out.println(result);

        String toDesirial = "{\"klicka\":\"Gayka\",\"age\":1,\"weight\":3}";
        StringReader reader = new StringReader(toDesirial);
        Cat gaika = mapper.readValue(reader, Cat.class);
        System.out.println("name = " + gaika.getName());
        System.out.println("age = " + gaika.getAge());
        System.out.println("weight = " + gaika.getWeight());
    }
}
