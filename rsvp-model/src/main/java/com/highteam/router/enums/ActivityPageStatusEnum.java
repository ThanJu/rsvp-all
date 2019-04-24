package com.highteam.router.enums;

public enum ActivityPageStatusEnum {

    DELETE(1,"未开始"),
    VALID(2,"进行中");

    private Integer code;

    private String name;


    ActivityPageStatusEnum(Integer code, String name){
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
        ActivityPageStatusEnum[] activityPageStatusEnums = ActivityPageStatusEnum.values();
        for(int i = 0; i < activityPageStatusEnums.length;i++){
            if(activityPageStatusEnums[i].code.equals(code)){
                return activityPageStatusEnums[i].name;
            }
        }
        return null;
    }
}
