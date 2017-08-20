package com.dreamer.admin.core.pojo;

import com.dreamer.admin.core.util.SpringUtil;
import com.dreamer.common.tool.StringTools;
import com.dreamer.pojo.AbstractBasePojo;
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

    public ResultDo setError(String error) {
        this.error = error;
        if (StringTools.isNotEmpty(this.error)) {
            this.isSuccess = false;
        }
        return this;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isError() {
        return !isSuccess;
    }

    public ResultDo setSuccess(boolean success) {
        isSuccess = success;
        return this;
    }


    /**
     * 获取messageSource的消息
     *
     * @param code
     * @return
     */
    private static String messageSource(String code) {
        return SpringUtil.getBean(MessageSource.class).getMessage(code, null, code, null);
    }


}