package thread.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import thread.service.AsyncService;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class AsyncServiceImpl implements AsyncService {
    @Resource
    ThreadPoolTaskExecutor executor;
    @Resource
    AsyncMethod asyncMethod;

    @Resource
    AsyncZRMethod asyncZRMethod;

    @Override
    @Async("threadPoolTaskExecutor")
    public void excuterAsyncVoid() {
        String name = Thread.currentThread().getName();
        System.out.println("---------当前线程开始执行:"+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("---------当前线程结束执行:"+name);

    }

    @Override
    public JSONObject excuterAsync() throws ExecutionException, InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println("---------当前线程开始执行:"+name);
        Future future = null;
        JSONObject json = new JSONObject();

        for (int i=0;i<10;i++){
            if (i<5){
                //通过线程池调用具体类方法，有返回值
                future = executor.submit(asyncMethod);
                json.put("async"+i,executor.submit(asyncMethod).get().toString());
            } else {
                //注解的方式，返回值可有可无，直接调用类方法
                json.put("async"+i,asyncZRMethod.mehtond(i).get().toString());

            }

        }


        System.out.println("---------当前线程结束执行:"+name);
        return json;
    }

}
