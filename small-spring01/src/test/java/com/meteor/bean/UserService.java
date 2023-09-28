package com.meteor.bean;

/*
 * @author meteor_01
 * @date 2023/9/21
 * @description 用户服务类，可作为Bean放到BeanDefinition中，然后注册到BeanFactory中，之后就能从BeanFactory中获取Bean
 **/
public class UserService {
    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }
}
