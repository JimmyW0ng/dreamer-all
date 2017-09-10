package com.dreamer.admin.service;

import com.dreamer.admin.pojo.po.SysLogPojo;
import com.dreamer.admin.repository.SysLogRepository;
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
