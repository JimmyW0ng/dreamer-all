package com.dreamer.admin.advice;

import com.dreamer.admin.core.constant.MessageCodeConstant;
import com.dreamer.admin.core.pojo.ResultDo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JW on 17/8/20.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultDo returnExceptionWithUrl(Exception ex) {
        return ResultDo.build(MessageCodeConstant.ERROR_SYSTEM);
    }

}
