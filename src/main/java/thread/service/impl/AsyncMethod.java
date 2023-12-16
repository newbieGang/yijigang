package thread.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import thread.config.DateUtils;

import java.util.concurrent.Callable;

@Configuration
public class AsyncMethod implements Callable {
    @Override
    public JSONObject call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"线程开始时间："+ DateUtils.getFormatCurrentTime("yyyy/MM/DD HH:mm:ss"));
        JSONObject json = new JSONObject();
        json.put("AsyncMethod",name);
        try {
            Thread.sleep(1);
            System.out.println(json.toJSONString());
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(name+"结束时间："+DateUtils.getFormatCurrentTime("yyyy/MM/DD HH:mm:ss"));
        return json;
    }
}
