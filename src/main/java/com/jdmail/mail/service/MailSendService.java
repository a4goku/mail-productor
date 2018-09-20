package com.jdmail.mail.service;

import com.jdmail.mail.entity.MailSend;
import com.jdmail.mail.mapper.MailSend1Mapper;
import com.jdmail.mail.mapper.MailSend2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

    @Autowired
    private MailSend1Mapper mailSend1Mapper;

    @Autowired
    private MailSend2Mapper mailSend2Mapper;

    public void insert(MailSend mailSend) throws Exception{
        int hashCode = mailSend.getSendId().hashCode();
        if(hashCode % 2 == 0){
            mailSend1Mapper.insert(mailSend);
        } else {
            mailSend2Mapper.insert(mailSend);
        }
    }

    public void sendRedis(MailSend mailSend){

    }
}
