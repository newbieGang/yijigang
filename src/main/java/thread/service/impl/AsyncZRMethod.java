package thread.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

@Configuration
public class AsyncZRMethod {
    @Async("threadPoolTaskExecutor")
    public Future<String> mehtond(int num){
        String name = Thread.currentThread().getName();
        System.out.println(name+"-"+num+"-"+System.currentTimeMillis());
        return new AsyncResult<String>(String.format(name+"-"+num));
    }
}
