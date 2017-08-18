package com.dreamer.pojo;

import lombok.Data;

/**
 * Created by jimmy on 2017/2/9.
 */
@Data
public class ResultDo<T> extends AbstractBasePojo {

    private boolean isSuccess = true;
    /**
     * 错误码
     */
    private String error;
    /**
     * 错误描述信息
     */
    private String errorDescription;

    /**
     * 返回结果对象
     */
    private T result;

    public ResultDo() {

    }

    public static ResultDo build() {
        return new ResultDo();
    }
}