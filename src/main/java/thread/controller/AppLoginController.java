package thread.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import thread.service.AsyncService;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/")
public class AppLoginController {


    @Resource
    AsyncService asyncService;

    @RequestMapping(value = "/login")
    public String login (){
        return "login success !";
    }
    @ResponseBody
    @RequestMapping(value = "/async")
    public JSONObject async () throws ExecutionException, InterruptedException {
        JSONObject rs = asyncService.excuterAsync();
        return rs;
    }
}
