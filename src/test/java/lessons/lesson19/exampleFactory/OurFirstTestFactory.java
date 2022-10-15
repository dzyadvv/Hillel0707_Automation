package lessons.lesson19.exampleFactory;

import org.testng.annotations.Test;

public class OurFirstTestFactory {

    @Test(groups = {"regression"})
    public void firstTestMethod() {
        System.out.println("It's a first test method");
    }

    @Test
    public void secondTestMethod() {
        System.out.println("It's a second test method");
    }
}
