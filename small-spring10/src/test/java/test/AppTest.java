package test;


import com.meteor.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import test.event.CustomEvent;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L,"成功了"));
        applicationContext.registerShutdownHook();
    }

}
