package com.highteam.router.enums;

public enum ActivityChargeTypeEnum {

    CHARGE(1,"全部收费"),
    FREE_CHARGE(2,"全部免费"),
    CHARGE_FREE_CHARGE(3,"收费+免费");

    private Integer code;

    private String name;


    ActivityChargeTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getName(Integer code){
        ActivityChargeTypeEnum[] activityInfoStatusEnums = ActivityChargeTypeEnum.values();
        for(int i = 0; i < activityInfoStatusEnums.length;i++){
            if(activityInfoStatusEnums[i].code.equals(code)){
                return activityInfoStatusEnums[i].name;
            }
        }
        return null;
    }
}
