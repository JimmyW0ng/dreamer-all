package com.dreamer.business.service;

import com.dreamer.business.repository.SysDictRepository;
import com.dreamer.pojo.po.SysDictPojo;
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