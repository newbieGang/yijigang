package thread.config.factory;

import org.springframework.beans.factory.InitializingBean;

public abstract class Handle implements InitializingBean {

    public void run(){
        throw new UnsupportedOperationException();
    }

    public void run1(String var){
        throw new UnsupportedOperationException();
    }
}
