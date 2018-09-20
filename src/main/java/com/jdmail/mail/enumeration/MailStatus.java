package com.jdmail.mail.enumeration;

public enum MailStatus {
    /*暂存/待发送*/
    DRAFT("0"),
    /*发送中/已进入redis队列*/
    SEND_IN("1"),
    /*发送成功*/
    SEND_OK("2"),
    /*发生失败*/
    SEND_ERR("3");

    private String code;

    private MailStatus(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
