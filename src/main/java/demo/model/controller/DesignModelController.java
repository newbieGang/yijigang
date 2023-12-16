package demo.model.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thread.service.FactoryService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/")
public class DesignModelController {

    @Resource
    FactoryService factoryService;

    @RequestMapping(value = "/dType")
    public String getModel(String type){
        factoryService.getCondition();
        return null;

    }
}
