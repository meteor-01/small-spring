package com.meteor;

import static org.junit.Assert.assertTrue;

import com.meteor.test.bean.IUserService;
import com.meteor.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class AppTest 
{

    @Test
    public void test_property(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果："+userService);
    }

    @Test
    public void test_scan(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果："+userService.queryUserInfo());
    }
}
