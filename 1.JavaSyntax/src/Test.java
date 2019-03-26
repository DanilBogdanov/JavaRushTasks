/**
 * Created by Администратор on 14.07.2018.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Integer.parseInt("3.3");
        } catch (Exception e) {
            System.out.println("some trouble");
        }
    }
}
