package com.dreamer.admin.service;

import com.dreamer.admin.pojo.po.SysDictPojo;
import com.dreamer.admin.repository.SysDictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jw on 2017/1/16.
 */
@Service
public class SysDictService {
    @Autowired
    private SysDictRepository sysDictRepository;

    public SysDictPojo getOneByKey(String key) {
        return sysDictRepository.findOneByKey(key);
    }
}