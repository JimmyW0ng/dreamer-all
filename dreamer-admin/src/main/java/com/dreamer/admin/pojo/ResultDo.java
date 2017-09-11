package com.dreamer.admin.pojo;

import com.dreamer.common.tool.SpringTools;
import com.dreamer.common.tool.StringTools;
import org.springframework.context.MessageSource;

/**
 * Created by jimmy on 2017/2/9.
 */
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

    public static ResultDo build(String messCodeConstant) {
        ResultDo resultDo = new ResultDo();
        resultDo.setError(messCodeConstant).setErrorDescription(messageSource(messCodeConstant)).setSuccess(false);
        return resultDo;
    }

    /**
     * 获取messageSource的消息
     *
     * @param code
     * @return
     */
    private static String messageSource(String code) {
        return SpringTools.getBean(MessageSource.class).getMessage(code, null, code, null);
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public ResultDo setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        if (StringTools.isNotEmpty(this.errorDescription)) {
            this.setSuccess(false);
        }
        return this;
    }

    public String getError() {
        return error;
    }

    public T getResult() {
        return result;
    }

    public ResultDo setResult(T result) {
        this.result = result;
        return this;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public ResultDo setSuccess(boolean success) {
        isSuccess = success;
        return this;
    }

    public boolean isError() {
        return !isSuccess;
    }

    public ResultDo setError(String error) {
        this.error = error;
        if (StringTools.isNotEmpty(this.error)) {
            this.isSuccess = false;
        }
        return this;
    }


}