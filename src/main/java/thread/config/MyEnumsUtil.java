package thread.config;

import org.springframework.util.CollectionUtils;
import thread.enums.IEnum;
import thread.enums.ValueIEnum;
import thread.enums.impl.TestEnum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyEnumsUtil {
    public static <T> List<T> getEnums(Class<T> enumClass){
        if (enumClass == null) return null;
        Object[] enumList = enumClass.getEnumConstants();
        if (enumList == null) {
            return null;
        } else {
            return (List<T>) Arrays.asList(enumList);
        }
    }

    public static <T extends ValueIEnum<String>> T getEnumByValue (Class<T> enumClass, String value){
        List<T> emnuList = getEnums(enumClass);
        if (CollectionUtils.isEmpty(emnuList) || value == null) return null;
        for (ValueIEnum<String> em : emnuList){
            if (((String)em.getEnumValue()).equals(value)){
                return (T) em;
            }
        }
        return null;
    }

    public static String getNameByValue(Class<? extends IEnum<String>> enumCass, String value){
        IEnum<String> em = (IEnum) getEnumByValue(enumCass,value);
        return em.getEnumName();
    }

    public static void main(String[] args) {
        String name = getNameByValue(TestEnum.class,"ds");
        System.out.println("------"+name);
    }


}
