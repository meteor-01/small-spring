package com.meteor;

import com.meteor.bean.UserService;
import org.junit.Test;

public class MainTest {

    @Test
    public void test_BeanFactory(){
        //初始化BeanFaactory
        BeanFactory beanFactory = new BeanFactory();

        //注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
