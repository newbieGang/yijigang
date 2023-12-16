package thread.config;

import java.math.BigDecimal;

public class BigdecialUtil {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /*
    * 相加
    * */
    public static double add(double d1,double d2){
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }

    public static double add(String s1,String s2){
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        return b1.add(b2).doubleValue();
    }

    public static String add(String s1,String s2,int scale){
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);

        return b1.add(b2).setScale(scale,BigDecimal.ROUND_HALF_UP).toString();
    }
    /*
     * 精确减法
     * Double
     * */
    public static double sub(double d1,double d2){
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }
    /*
    * 精确减法
    * @Param s1 被减数
    * @Param s2 减数
    * */
    public static double sub(String s1,String s2){
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        return b1.subtract(b2).doubleValue();
    }
    /**
     *
     * 
     */
    public static String sub(String s1,String s2,int scale){
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);

        return b1.subtract(b2).setScale(scale,BigDecimal.ROUND_HALF_UP).toString();
    }

}
