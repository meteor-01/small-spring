package com.meteor;

import com.meteor.bean.UserDao;
import com.meteor.bean.Userservice;
import com.meteor.factory.config.BeanDefinition;
import com.meteor.factory.config.BeanReference;
import com.meteor.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testBeanFactory() {
        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2. UserDao注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(Userservice.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //5. UserService 获取bean
        Userservice userservice = (Userservice) beanFactory.getBean("userService");
        userservice.queryUserInfo();
    }

}
