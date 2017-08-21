package com.dreamer.admin.advice;

import com.dreamer.admin.core.constant.MessageCodeConstant;
import com.dreamer.admin.pojo.ResultDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JW on 17/8/20.
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultDo returnExceptionWithUrl(Exception ex) {
        log.error("系统异常!", ex);
        return ResultDo.build(MessageCodeConstant.ERROR_SYSTEM).setErrorDescription(ex.getMessage());
    }

}
