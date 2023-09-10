package com.meteor.beans.factory.config;


import com.meteor.beans.PropertyValues;
/*
    bean定义信息
 */
public class BeanDefinition {
    private Class beanClass;
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private String scope = SCOPE_SINGLETON;

    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }


    private boolean singleton = true;
    private boolean prototype = false;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    private PropertyValues propertyValues;

    private String initMethodName;
    private String destroyMethodName;

    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues){
        this.beanClass = beanClass;
        this.propertyValues = propertyValues!=null?propertyValues:new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getSCOPE_SINGLETON() {
        return SCOPE_SINGLETON;
    }

    public void setSCOPE_SINGLETON(String SCOPE_SINGLETON) {
        this.SCOPE_SINGLETON = SCOPE_SINGLETON;
    }

    public String getSCOPE_PROTOTYPE() {
        return SCOPE_PROTOTYPE;
    }

    public void setSCOPE_PROTOTYPE(String SCOPE_PROTOTYPE) {
        this.SCOPE_PROTOTYPE = SCOPE_PROTOTYPE;
    }
}
