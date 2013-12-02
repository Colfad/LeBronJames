package com.zxy.web.framework.locus.exception;

/**
 * 上传文件不是允许的类型
 *
 * @author James
 */
public class UploadFileExtensionPermitException extends RuntimeException {

    public UploadFileExtensionPermitException() {
        super();
    }

    public UploadFileExtensionPermitException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public UploadFileExtensionPermitException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadFileExtensionPermitException(Throwable cause) {
        super(cause);
    }
}
