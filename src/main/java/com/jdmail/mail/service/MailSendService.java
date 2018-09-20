package com.jdmail.mail.service;

import com.jdmail.mail.entity.MailSend;
import com.jdmail.mail.enumeration.MailStatus;
import com.jdmail.mail.enumeration.RedisPriorityQueue;
import com.jdmail.mail.mapper.MailSend1Mapper;
import com.jdmail.mail.mapper.MailSend2Mapper;
import com.jdmail.mail.utils.FastJsonConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

    private static Logger LOGGER = LoggerFactory.getLogger(MailSendService.class);
    @Autowired
    private MailSend1Mapper mailSend1Mapper;

    @Autowired
    private MailSend2Mapper mailSend2Mapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void insert(MailSend mailSend) throws Exception {
        int hashCode = mailSend.getSendId().hashCode();
        if (hashCode % 2 == 0) {
            mailSend2Mapper.insert(mailSend);
        } else {
            mailSend1Mapper.insert(mailSend);
        }
    }

    public void sendRedis(MailSend mailSend) {
        ListOperations<String, String> opsForList = redisTemplate.opsForList();
        Long priority = mailSend.getSendPriority();

        Long ret = 0L;
        Long size = 0L;

        if (priority < 4L) {
            //进入延迟队列
            ret = opsForList.rightPush(RedisPriorityQueue.DEFER_QUEUE.getCode(), FastJsonConvertUtil.convertObjectToJSON(mailSend));
            size = opsForList.size(RedisPriorityQueue.DEFER_QUEUE.getCode());
        } else if (priority < 7) {
            //进入普通队列
            ret = opsForList.rightPush(RedisPriorityQueue.NORMAL_QUEUE.getCode(), FastJsonConvertUtil.convertObjectToJSON(mailSend));
            size = opsForList.size(RedisPriorityQueue.NORMAL_QUEUE.getCode());
        } else {
            //
            ret = opsForList.rightPush(RedisPriorityQueue.FAST_QUEUE.getCode(), FastJsonConvertUtil.convertObjectToJSON(mailSend));
            size = opsForList.size(RedisPriorityQueue.FAST_QUEUE.getCode());
        }

        mailSend.setSendCount(mailSend.getSendCount() + 1);

        if (ret == size) {
            mailSend.setSendStatus(MailStatus.SEND_IN.getCode());
            if (mailSend.getSendId().hashCode() % 2 == 0) {
                mailSend2Mapper.updateByPrimaryKeySelective(mailSend);
            } else {
                mailSend1Mapper.updateByPrimaryKeySelective(mailSend);
            }
            LOGGER.info("--------进入队列成功，id：{}---------", mailSend.getSendId());
        } else {
            mailSend.setSendCount(mailSend.getSendCount() + 1);
            if (mailSend.getSendId().hashCode() % 2 == 0) {
                mailSend2Mapper.updateByPrimaryKeySelective(mailSend);
            } else {
                mailSend1Mapper.updateByPrimaryKeySelective(mailSend);
            }
            LOGGER.info("--------进入队列失败，等待轮询机制重新投递，id：{}---------", mailSend.getSendId());
        }
    }
}
