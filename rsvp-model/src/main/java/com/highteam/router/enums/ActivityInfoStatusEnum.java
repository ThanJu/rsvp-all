package com.highteam.router.enums;

public enum ActivityInfoStatusEnum {

    NOT_START(1,"未开始"),
    LOADING(2,"进行中"),
    FINISHED(2,"已结束"),;

    private Integer code;

    private String name;


    ActivityInfoStatusEnum(Integer code, String name){
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
        ActivityInfoStatusEnum[] activityInfoStatusEnums = ActivityInfoStatusEnum.values();
        for(int i = 0; i < activityInfoStatusEnums.length;i++){
            if(activityInfoStatusEnums[i].code.equals(code)){
                return activityInfoStatusEnums[i].name;
            }
        }
        return null;
    }
}
