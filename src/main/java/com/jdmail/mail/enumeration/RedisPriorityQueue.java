package com.jdmail.mail.enumeration;

public enum  RedisPriorityQueue {
    //7,8,9 隐藏、安全、交易
    FAST_QUEUE("fast"),

    //4,5,6 活动、通知类
    NORMAL_QUEUE("normal"),

    //1,2,3 汇总、调查
    DEFER_QUEUE("defer");

    private String code;

    private RedisPriorityQueue(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
