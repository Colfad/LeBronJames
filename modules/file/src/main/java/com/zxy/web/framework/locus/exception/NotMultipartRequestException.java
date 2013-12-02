package com.zxy.web.framework.locus.exception;

/**
 * Request请求并不包含Multipart的类型
 *
 * @author James
 */
public class NotMultipartRequestException extends RuntimeException {
    public NotMultipartRequestException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public NotMultipartRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotMultipartRequestException(Throwable cause) {
        super(cause);
    }
}
