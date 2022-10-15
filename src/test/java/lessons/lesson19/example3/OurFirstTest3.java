package lessons.lesson19.example3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OurFirstTest3 {


    //  @Parameters({"username", "password"})
    @Test(groups = {"regression"})
    //  public void firstTestMethod(String user, String pass) {
    public void firstTestMethod() {
        System.out.println("It's a first test method");
        //      System.out.println(user);
        //      System.out.println(pass);
    }

    @Test
    public void secondTestMethod() {
        System.out.println("It's a second test method");
    }
}
