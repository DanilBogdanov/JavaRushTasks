package Test;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IOException {
        Long l1 = new Long(1);
        Long l2 = new Long(1);
        System.out.println(l1 == l2);
        System.out.println(l1.equals(l2));

    }


}
