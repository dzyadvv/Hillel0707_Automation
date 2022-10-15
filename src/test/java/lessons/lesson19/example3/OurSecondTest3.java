package lessons.lesson19.example3;

import org.testng.annotations.Test;

public class OurSecondTest3 {

    @Test(groups = {"regression"})
    public void thirdTestMethod(){
        System.out.println("It's a third test method");
    }
}
