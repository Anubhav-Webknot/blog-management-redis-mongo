package com.blogmanagement.blogmanagement.Error;

public class BlogNotFoundException extends Exception{
    public BlogNotFoundException() {
        super();
    }

    public BlogNotFoundException(String message) {
        super(message);
    }

    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BlogNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
