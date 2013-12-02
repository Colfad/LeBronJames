package com.zxy.web.framework.locus.exception;


/**
 * 上传文件的内容过大Exception
 *
 * @author James
 */
public class UploadFileContentTooBigException extends RuntimeException {

    public UploadFileContentTooBigException(String message) {
        super(message);
    }

    public UploadFileContentTooBigException() {
        super();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public UploadFileContentTooBigException(Throwable cause) {
        super(cause);
    }

    public UploadFileContentTooBigException(String message, Throwable cause) {
        super(message, cause);
    }
}
