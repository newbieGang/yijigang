package thread.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

public interface AsyncService {
    /*
    * @description 异步执行无返回值方法
    * @author yijigang
    *
    */
    void excuterAsyncVoid ();

    /*
    * @description 异步执行有返回值方法
    * @author yijigang
    */
    JSONObject excuterAsync () throws ExecutionException, InterruptedException;
}
