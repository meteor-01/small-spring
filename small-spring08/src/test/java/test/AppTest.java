package test;


import com.meteor.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import test.bean.UserService;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationnContextAware:"+userService.getApplicationContext());
    }

}
