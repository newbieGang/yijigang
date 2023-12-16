package thread.service.impl;

import org.springframework.stereotype.Service;
import thread.config.factory.Factory;
import thread.config.factory.Handle;
import thread.service.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Override
    public void getCondition() {
        Handle handle = Factory.getCondition("condition");
        handle.run();
    }
}
