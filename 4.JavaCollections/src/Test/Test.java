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
        Path path = Paths.get("/home/danil/");

        for (Path p : Files.newDirectoryStream(path)){
            System.out.println(p.toString());
        }

        m(new Cl<String>(), new Cl<>());

    }

    static class Cl<T> {


    }

    static <T> void m(Cl<T> ... a) {
    }

}
