package com.meteor;

import com.meteor.bean.IUserService;
import com.meteor.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


public class AppTest
{
    @Test
    public void test_aop(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果："+userService.queryUserInfo());
    }
}
