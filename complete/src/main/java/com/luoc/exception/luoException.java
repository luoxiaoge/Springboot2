package com.luoc.exception;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 13:41
 */
public class luoException extends RuntimeException {

    public luoException() {
        super();
    }

    public luoException(String message) {
        super(message);
    }

    public luoException(String message, Throwable cause) {
        super(message, cause);
    }

    public luoException(Throwable cause) {
        super(cause);
    }

    protected luoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
