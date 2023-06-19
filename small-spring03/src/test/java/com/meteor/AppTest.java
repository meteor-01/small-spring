package com.meteor;

import com.meteor.bean.UserService;
import com.meteor.factory.config.BeanDefinition;
import com.meteor.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class AppTest {
    @Test
    public void testBeanFactory() {
        //1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2. 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService", "meteor");
        userService.queryUserInfo();
    }
}