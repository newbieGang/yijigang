package thread.enums.impl;

import thread.enums.IEnum;

public enum TestEnum implements IEnum<String> {

    RETT("d","ds");

    private String enumValue;



    private String enumName;

    private TestEnum(String enumName,String enumValue){
        this.enumName = enumName;
        this.enumValue = enumValue;
    }

    public String getEnumValue() {
        return enumValue;
    }


    public String getEnumName() {
        return enumName;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }
}
