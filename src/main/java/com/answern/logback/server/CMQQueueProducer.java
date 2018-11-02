package com.answern.logback.server;


import com.qcloud.cmq.Account;
import com.qcloud.cmq.Queue;

public class CMQQueueProducer  extends Account {

    public CMQQueueProducer() {
        super();
    }
    public CMQQueueProducer(String endpoint, String secretId, String secretKey) {
        super(endpoint, secretId, secretKey);
    }

    public CMQQueueProducer(String secretId, String secretKey, String endpoint, String path, String method) {
        super(secretId, secretKey, endpoint, path, method);
    }

    /**
     * 发送同步消息 单个消息
     * @param queueName
     * @param message
     * @return
     */
    public String sendMessage(String queueName,String message) throws Exception {
        Queue queue =getQueue(queueName);
        return queue.sendMessage(message);
    }
}
