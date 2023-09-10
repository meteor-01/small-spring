package com.meteor.aop.framework;

import com.meteor.aop.AdvisedSupport;

public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport){
        this.advisedSupport = advisedSupport;
    }
    public Object getProxy(){
        return createAopProxy().getProxy();
    }
    public AopProxy createAopProxy(){
        if(advisedSupport.isProxyTargetClass()){
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
