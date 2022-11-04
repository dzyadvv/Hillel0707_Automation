package lessons.lesson28;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssert {

    @Test(enabled = false)
    public void testCaseOne(){
        System.out.println("*** test case one started ***");
        Assert.assertEquals(5, 5);
        System.out.println("hard assert success ..........");
        Assert.assertTrue("Hello".equals("hello"));
        System.out.println("*** test case execute successfully ***");
    }

    @Test
    public void testCaseTwo(){
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
        System.out.println("*** test case two started ***");
        softAssert.assertEquals(5, 5);
        System.out.println("hard assert success ..........");
        softAssert.assertTrue("Hello".equals("hello"));
        System.out.println("*** test case execute successfully ***");
        softAssert.assertAll();
    }
}
