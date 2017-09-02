package com.dreamer.admin.controller;

import com.dreamer.admin.pojo.ResultDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JW on 17/9/2.
 */
@Controller
@RequestMapping("security")
@Slf4j
public class SessionController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ResultDo index(Model model) {
        return ResultDo.build();
    }
}
