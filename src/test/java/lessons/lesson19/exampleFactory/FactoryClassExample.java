package lessons.lesson19.exampleFactory;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryClassExample {

    @Factory
    @Test
    public Object[] getFactoryTests(){
        Object[] factory = new Object[2];
        factory[0] = new OurFirstTestFactory();
        factory[1] = new OurSecondTestFactory();
        return factory;
    }
}
