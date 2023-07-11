package test.common;

import com.meteor.beans.BeansException;
import com.meteor.beans.PropertyValue;
import com.meteor.beans.PropertyValues;
import com.meteor.beans.factory.ConfigurableListableBeanFactory;
import com.meteor.beans.factory.config.BeanDefinition;
import com.meteor.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertryValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：tencent"));
    }
}
