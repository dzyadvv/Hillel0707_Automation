package lessons.lesson18;

import org.testng.annotations.*;

//public class lessons.lesson18.OurFirstTest {
//
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("executed method before test");
//    }
//
//    @Test
//    public void firstTest(){
//        System.out.println("open google.com.ua");
//    }
//
//    @Test
//    public void secondTest(){
//        System.out.println("open apple.com");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("executed method after test");
//    }
//}

//public class lessons.lesson18.OurFirstTest {
//
// // выполняется перед каждым методом
//    @BeforeMethod
//    public void beforeTest() {
//        System.out.println("executed method before test");
//    }
//
//    @Test
//    public void firstTest(){
//        System.out.println("open google.com.ua");
//    }
//
//    @Test
//    public void secondTest(){
//        System.out.println("open apple.com");
//    }
//}


//public class lessons.lesson18.OurFirstTest {
//
//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("executed method before test");
//    }
//
//    @BeforeMethod
//    public void beforeTest() {
//        System.out.println("executed method before test");
//    }
//
//    @Test
//    public void firstTest(){
//        System.out.println("open google.com.ua");
//    }
//
//    @Test
//    public void secondTest(){
//        System.out.println("open apple.com");
//    }
//}


//public class lessons.lesson18.OurFirstTest {
//
//    @Test(description = "описание теста краткое")
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}


//public class lessons.lesson18.OurFirstTest {
//
//    @Test(alwaysRun = true)
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test(dependsOnMethods = "firstTest", alwaysRun = true)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test()
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test(dataProvider = "")
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test(groups = "payment")
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test(groups = "payment")
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test(groups = "payment")
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    // если хоть один из groups зафейлится, то dependsOnGroups не запустится
//    // alwaysRun запустит
//    @Test(dependsOnGroups = "payment", alwaysRun = true)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//
//    // не пройдет
//    @Test(dependsOnGroups = "payment")
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test(priority = 1)
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    // запустится первый
//    @Test(priority = 0)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}


//public class lessons.lesson18.OurFirstTest {
//
//    @Test()
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    //не запустится
//    @Test(enabled = false)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test(timeOut = 1)
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//        for(int i = 0; i < 5000; i++){
//            System.out.println(i);
//        }
//    }
//
//    @Test(enabled = false)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test(invocationCount = 3)
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test(enabled = false)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}


//public class lessons.lesson18.OurFirstTest {
//
//    @Test(invocationCount = 3, invocationTimeOut = 20)
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//    }
//
//    @Test(enabled = false)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test(expectedExceptions = {ArithmeticException.class})
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//        System.out.println(7/0);
//    }
//
//    @Test(enabled = false)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}



//public class lessons.lesson18.OurFirstTest {
//
//    @Test(expectedExceptions = {Error.class})
//    public void firstTest(){
//        System.out.println("opened google.com.ua");
//        System.out.println(7/0);
//    }
//
//    @Test(enabled = false)
//    public void secondTest(){
//        System.out.println("opened apple.com");
//    }
//}


public class OurFirstTest {

    @Test(expectedExceptions = {Error.class})
    public void firstTest(){
        System.out.println("opened google.com.ua");
        System.out.println(7/0);
    }

    @Parameters
    @Test(enabled = false)
    public void secondTest(){
        System.out.println("opened apple.com");
    }
}