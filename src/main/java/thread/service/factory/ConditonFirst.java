package thread.service.factory;

import org.springframework.stereotype.Component;
import thread.config.factory.Factory;
import thread.config.factory.Handle;

@Component
public class ConditonFirst extends Handle {
    @Override
    public void run() {
        System.out.println("ConditionFisrt Run()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("condition",this);

    }
}
