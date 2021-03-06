package com.jdmail.mail.controller;

import com.jdmail.mail.entity.MailSend;
import com.jdmail.mail.enumeration.MailStatus;
import com.jdmail.mail.service.MailSendService;
import com.jdmail.mail.utils.KeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorController.class);

    @Autowired
    private MailSendService mailSendService;

    @RequestMapping(value = "/send", produces = {"application/json;charset=UTF-8"})
    public void send(@RequestBody(required = false) MailSend mailSend) throws Exception {

        try {
            //1数据校验

            //2入库
            mailSend.setSendId(KeyUtil.generatorUUID());
            mailSend.setSendCount(0L);
            mailSend.setSendStatus(MailStatus.DRAFT.getCode());
            mailSend.setUpdateBy("");
            mailSendService.insert(mailSend);

            //3把数据放入redis
            mailSendService.sendRedis(mailSend);

        } catch (Exception e) {
            LOGGER.error("异常信息：{}", e);
            throw new RuntimeException(e);
        }
    }
}
