package com.highteam.router.enums;

public enum  ActivitySignWayTypeEnum {

    COMPUTER(1,"电脑签到"),
    SELF_HELP(2,"自助签到"),
    RFID(3,"RFID签到"),
    FACE(4,"人脸签到"),
    QR(5,"二维码");

    private Integer code;

    private String name;


    ActivitySignWayTypeEnum(Integer code, String name){
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
        ActivitySignWayTypeEnum[] activitySignWayTypeEnums = ActivitySignWayTypeEnum.values();
        for(int i = 0; i < activitySignWayTypeEnums.length;i++){
            if(activitySignWayTypeEnums[i].code.equals(code)){
                return activitySignWayTypeEnums[i].name;
            }
        }
        return null;
    }
}

