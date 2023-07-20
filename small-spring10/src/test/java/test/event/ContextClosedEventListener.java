package test.event;

import com.meteor.context.ApplicationListener;
import com.meteor.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件："+this.getClass().getName());
    }
}
