package lessons.lesson19.exampleListener;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFirstTestListener {


    @Parameters({"username", "password"})
    @Test
    public void firstTestMethod(String user, String pass) {
        System.out.println("It's a first test method");
        System.out.println(user);
        System.out.println(pass);
    }

    @Test
    public void secondTestMethod() {
        System.out.println("It's a second test method");
    }
}
