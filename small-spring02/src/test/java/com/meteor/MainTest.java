package com.meteor;

import com.meteor.beans.UserService;
import com.meteor.factory.config.BeanDefinition;
import com.meteor.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class MainTest {
    /*
    先将bean的类信息加入到beanDefinition中，然后注册到beanFactory(就是一个map)中，获取bean时，先
    检查在单例map中是否已经存在，若存在则直接返回，否则获取beanDefinition然后创建Bean，创建Bean后将
    Bean加入到单例map中,最后返回创建的Bean
     */
    @Test
    public void testBeanFactory() throws BeansException {
        //1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2. 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        //4. 第二次获取 bean from Singleton
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
        //验证两个bean是否是同一个
        System.out.println(userService==userService1);
    }
}
