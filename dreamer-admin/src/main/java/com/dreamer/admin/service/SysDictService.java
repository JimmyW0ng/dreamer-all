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

    public SysDictPojo findByGroupNameAndKey(String groupName, String key) {
        return sysDictRepository.findByGroupNameAndKey(groupName, key);
    }

    public int updateByGroupName(String groupName, String key, String value) {
        return sysDictRepository.updateByGroupName(groupName, key, value);
    }
}