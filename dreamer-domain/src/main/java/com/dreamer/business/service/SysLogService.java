package com.dreamer.business.service;

import com.dreamer.business.repository.SysLogRepository;
import com.dreamer.pojo.po.SysLogPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jw on 2017/1/16.
 */
@Service
public class SysLogService {

    @Autowired
    private SysLogRepository sysLogRepository;

    public void insert(SysLogPojo pojo) {
        sysLogRepository.insert(pojo);
    }

}
