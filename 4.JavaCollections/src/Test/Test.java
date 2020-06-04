package Test;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IOException {
        String string = "127.0.0.1\tAmigo\t30.08.2012 16:08:13\tLOGIN\tOK";
        Pattern patternIp = Pattern.compile("(?<ip>[\\d]+\\.[\\d]+\\.[\\d]+\\.[\\d]+)\\s.*(?<name>\\.20.*:)");
        //Pattern patternIp = Pattern.compile("(?<name>\\.20.*:)");
        Matcher matcher = patternIp.matcher(string);
        matcher.find();
        System.out.println("ip:\t" + matcher.group("ip"));
        System.out.println("name:\t" + matcher.group("name"));
    }


}
