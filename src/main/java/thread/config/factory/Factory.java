package thread.config.factory;

import org.springframework.util.StringUtils;

import java.util.HashMap;

/*
*工厂模式，创建工厂
*
*/
public class Factory {

    public static HashMap<String, Handle> conditonMap = new HashMap<>();

    public static Handle getCondition(String name){
        return conditonMap.get(name);
    }
    public static void register(String name, Handle handle){
        if (StringUtils.isEmpty(name) || null == handle) {
            return;
        }
        conditonMap.put(name, handle);
        System.out.println("name:"+name+"handle:"+handle.getClass());
    }
}
