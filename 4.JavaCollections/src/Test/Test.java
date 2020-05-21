package Test;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IOException {
        logger.debug("main ");
        logger.info("string");
        logger.error("aad");
        A<Number> a = new A<>();

        C c = new C();

        a.t = 3;
        a.method("method");

    }

    static class A<T> {
        T t;

        <TR>TR method (TR tt) {

            return tt;
        }
    }

    static class C extends A {}
}
