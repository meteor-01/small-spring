package com.meteor.bean;

/*
 * author: meteor_01
 * date: 2023/10/9
 * desc: 用户服务类，可作为 Bean 放到 BeanDefinition 中，也是我们想从容器中获取到的目标类
 **/
public class UserService {
    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }
}
