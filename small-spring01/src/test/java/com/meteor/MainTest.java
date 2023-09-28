package com.meteor;

import com.meteor.bean.UserService;
import org.junit.Test;

/*
* @author meteor_01
* @date 2023/9/21
* @description 测试
**/
public class MainTest {
    //IOC大致上的四个步骤，创建BeanFactory，将Bean的信息存入BeanDefinition，然后把BeanDefinition注册到BeanFactory中，之后获取Bean时就会根据BeanDefiniton中存储的Bean的基本信息实例化Bean，最后将实例化后的Bean返回，就能使用Bean了。本模块省略了大量细节，直接将实例化好的Bean存入到BeanDefinition中，之后的模块会将这个过程放入到BeanFactory中
    @Test
    public void test_BeanFactory(){
        //初始化 BeanFaactory
        BeanFactory beanFactory = new BeanFactory();

        //将创建好的Bean即 UserService 放入到 BeanDefinition 中
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        //将 BeanDefinition 注册到 BeanFactory 中
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //从 BeanFactory 中获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
