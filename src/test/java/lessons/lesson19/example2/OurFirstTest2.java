package lessons.lesson19.example2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFirstTest2 {


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
