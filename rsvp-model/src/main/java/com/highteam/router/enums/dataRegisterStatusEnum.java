package com.highteam.router.enums;

public enum dataRegisterStatusEnum {

    NOT_SIGN(1,"未签到"),
    ALREADY_SIGN(2,"已签到"),
    AUDIT(3,"审核中");

    private Integer code;

    private String name;


    dataRegisterStatusEnum(Integer code, String name){
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
        dataRegisterStatusEnum[] activityPageStatusEnums = dataRegisterStatusEnum.values();
        for(int i = 0; i < activityPageStatusEnums.length;i++){
            if(activityPageStatusEnums[i].code.equals(code)){
                return activityPageStatusEnums[i].name;
            }
        }
        return null;
    }
}
