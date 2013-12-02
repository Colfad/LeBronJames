package com.zxy.web.module.core.info;

import java.io.Serializable;

/**
 * 操作信息类,通过JACKSON将对象转换为JSON数据,再返回至前台进行展现的操作
 *
 * @author James
 */
@SuppressWarnings("serial")
public class OperateInfo implements Serializable {
    private String operateMessage;

    private String operateSuccessUrl;

    private boolean operateSuccess;

    public String getOperateMessage() {
        return operateMessage;
    }

    public void setOperateMessage(String operateMessage) {
        this.operateMessage = operateMessage;
    }

    public String getOperateSuccessUrl() {
        return operateSuccessUrl;
    }

    public void setOperateSuccessUrl(String operateSuccessUrl) {
        this.operateSuccessUrl = operateSuccessUrl;
    }

    public boolean isOperateSuccess() {
        return operateSuccess;
    }

    public void setOperateSuccess(boolean operateSuccess) {
        this.operateSuccess = operateSuccess;
    }
}
