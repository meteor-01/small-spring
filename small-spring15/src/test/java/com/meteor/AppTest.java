package com.meteor;

import com.meteor.context.support.ClassPathXmlApplicationContext;
import com.meteor.test.bean.IUserService;
import org.junit.Test;

public class AppTest{
    @Test
    public void test_autoProxy(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果："+userService.queryUserInfo());
    }
}
