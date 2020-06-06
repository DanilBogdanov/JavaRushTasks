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
        Test test = new Test();
        Elf elf = test.new Elf();

    }

    @interface Person
    {
        String name() default "";
        int live();
        int strength();
        int magic() default 0;
        int attack() default 0;
        int defense();
    }

    @Person(live=100, strength=10, magic=5, attack=20, defense=20)
    class Elf
    {

    }

    @Person(live=1000, strength=150, magic=250, attack=99, defense=99)
    class EvilMaster
    {
    }

}
