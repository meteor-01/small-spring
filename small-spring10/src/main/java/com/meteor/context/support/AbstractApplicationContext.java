package com.meteor.context.support;

import com.meteor.beans.BeansException;
import com.meteor.beans.factory.ConfigurableListableBeanFactory;
import com.meteor.beans.factory.config.BeanFactoryPostProcessor;
import com.meteor.beans.factory.config.BeanPostProcessor;
import com.meteor.context.ApplicationEvent;
import com.meteor.context.ApplicationListener;
import com.meteor.context.ConfigurableApplicationContext;
import com.meteor.context.event.ApplicationEventMulticaster;
import com.meteor.context.event.ContextClosedEvent;
import com.meteor.context.event.ContextRefreshedEvent;
import com.meteor.context.event.SimpleApplicationEventMulticaster;
import com.meteor.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;
/*
核心功能
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";
    private ApplicationEventMulticaster applicationEventMulticaster;
    //自动读取xml中的bean配置信息并进行bean定义信息的修改、注册bean修改、实例化单例对象
    @Override
    public void refresh() throws BeansException {
        //1. 创建 BeanFactory, 并加载 BeanDefinition
        refreshBeanFactory();

        //2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory =  getBeanFactory();

        //3. 添加ApplicationContextAwareProcessor，让继承自ApplicationContextAware 的Bean对象都能感知所属的ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4. 在Bean实例化之前，执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //5. BeanPostProcessor 需要提前于其它Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //6. 初始化事件发布者
        initApplicationEventMulticaster();

        //7. 注册事件监听器
        registerListeners();

        //8 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

        //9. 发布容器刷新完成事件
        finishRefresh();
    }
    private void initApplicationEventMulticaster(){
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }
    private void registerListeners(){
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for(ApplicationListener listener: applicationListeners){
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void finishRefresh(){
        publishEvent(new ContextRefreshedEvent(this));
    }
    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for(BeanFactoryPostProcessor beanFactoryPostProcessor: beanFactoryPostProcessorMap.values()){
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for(BeanPostProcessor beanPostProcessor: beanPostProcessorMap.values()){
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        //发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        //执行销毁单例bean的销毁方法
        getBeanFactory().destroySingletons();
    }
}
