package thread.service.factory;

import org.springframework.stereotype.Component;
import thread.config.factory.Factory;
import thread.config.factory.Handle;

@Component
public class ConditionTwo extends Handle {
    @Override
    public void run1(String var) {
        System.out.println("ConditonTwo run()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("conditon1",this);
    }
}
