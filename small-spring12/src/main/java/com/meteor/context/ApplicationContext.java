package com.meteor.context;

import com.meteor.beans.factory.HierarchicalBeanFactory;
import com.meteor.beans.factory.ListableBeanFactory;
import com.meteor.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {


}
