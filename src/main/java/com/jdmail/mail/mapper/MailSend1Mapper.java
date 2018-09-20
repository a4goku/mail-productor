package com.jdmail.mail.mapper;

import com.jdmail.mail.entity.MailSend;

public interface MailSend1Mapper {
    int deleteByPrimaryKey(String sendId);

    int insert(MailSend record);

    int insertSelective(MailSend record);

    MailSend selectByPrimaryKey(String sendId);

    int updateByPrimaryKeySelective(MailSend record);

    int updateByPrimaryKey(MailSend record);
}