package com.xusangbo.basemoudle.base;

import java.io.Serializable;


public class BaseRespose<T> implements Serializable {
    public String code;
    public String message;

    public T data;

    public boolean success() {
        return "200".equals(code);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "code='" + code + '\'' +
                ", msg='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
