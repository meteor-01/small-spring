package com.meteor;

import com.meteor.context.support.ClassPathXmlApplicationContext;
import com.meteor.test.Husband;
import com.meteor.test.HusbandMother;
import com.meteor.test.Wife;
import org.junit.Test;

public class AppTest{
    @Test
    public void test_circle(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband",Husband.class);
        Wife wife = applicationContext.getBean("wife",Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());

    }
}
