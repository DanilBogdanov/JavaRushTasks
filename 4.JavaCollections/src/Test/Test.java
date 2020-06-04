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
        String string1 = "127.0.0.1\tAmigo\t30.08.2012 16:08:13\tLOGIN\tOK";
        String string= "192.168.100.2\tVasya Pupkin\t30.08.2012 16:08:40\tDONE_TASK 15\tOK";
        Pattern patternIp = Pattern.compile("(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+)\\s" +
                "(?<name>[\\w\\s]+)\\s" +
                "(?<date>\\d{2}\\.\\d{2}\\.\\d{4}\\s\\d{2}:\\d{2}:\\d{2})\\s" +
                "(?<event>[A-z_]+)\\s" +
                "(?<task>\\d*)\\s?" +
                "(?<status>[A-z_]+)");
        //Pattern patternIp = Pattern.compile("\\w+");
        Matcher matcher = patternIp.matcher(string);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println("ip:\t" + matcher.group("ip"));
            System.out.println("name:\t" + matcher.group("name"));
            System.out.println("date:\t" + matcher.group("date"));
            System.out.println("event:\t" + matcher.group("event"));
            System.out.println("task:\t" + matcher.group("task"));
            System.out.println("status:\t" + matcher.group("status"));
        }
    }


}
