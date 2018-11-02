package com.qcloud.cmq;

import java.util.Vector;

/**
 *  Message class .
 *
 * @author York.
 *         Created 2016年9月26日.
 */
public class Message {
	
	/** 服务器返回的消息ID */
	public String msgId;
	/** 每次消费唯一的消息句柄，用于删除等操作 */
	public String receiptHandle;
	/** 消息体 */
	public String msgBody;
	/** 消息发送到队列的时间，从 1970年1月1日 00:00:00 000 开始的毫秒数 */
    public long enqueueTime;
	/** 消息下次可见的时间，从 1970年1月1日 00:00:00 000 开始的毫秒数 */
	public long nextVisibleTime;
	/** 消息第一次出队列的时间，从 1970年1月1日 00:00:00 000 开始的毫秒数 */
	public long firstDequeueTime;
	/** 出队列次数 */
	public	int dequeueCount;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getReceiptHandle() {
		return receiptHandle;
	}

	public void setReceiptHandle(String receiptHandle) {
		this.receiptHandle = receiptHandle;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public long getEnqueueTime() {
		return enqueueTime;
	}

	public void setEnqueueTime(long enqueueTime) {
		this.enqueueTime = enqueueTime;
	}

	public long getNextVisibleTime() {
		return nextVisibleTime;
	}

	public void setNextVisibleTime(long nextVisibleTime) {
		this.nextVisibleTime = nextVisibleTime;
	}

	public long getFirstDequeueTime() {
		return firstDequeueTime;
	}

	public void setFirstDequeueTime(long firstDequeueTime) {
		this.firstDequeueTime = firstDequeueTime;
	}

	public int getDequeueCount() {
		return dequeueCount;
	}

	public void setDequeueCount(int dequeueCount) {
		this.dequeueCount = dequeueCount;
	}

	public Vector<String> getMsgTag() {
		return msgTag;
	}

	public void setMsgTag(Vector<String> msgTag) {
		this.msgTag = msgTag;
	}

	public  Vector<String> msgTag;

}
