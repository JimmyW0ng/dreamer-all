package com.dreamer.admin.service;

import com.dreamer.admin.constant.MessageCodeConstant;
import com.dreamer.admin.domain.enums.BscFileBizType;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.dto.OgnInfoDto;
import com.dreamer.admin.pojo.po.BscFilePojo;
import com.dreamer.admin.pojo.po.OgnCoursePojo;
import com.dreamer.admin.pojo.po.OgnInfoPojo;
import com.dreamer.admin.repository.BscFileRepository;
import com.dreamer.admin.repository.OgnCourseRepository;
import com.dreamer.admin.repository.OgnInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by J.W on 2017/9/14 0014.
 */
@Service
public class OgnInfoService {

    @Autowired
    private OgnInfoRepository ognInfoRepository;
    @Autowired
    private BscFileRepository bscFileRepository;
    @Autowired
    private OgnCourseRepository ognCourseRepository;

    public ResultDo<OgnInfoDto> getOgnDetail(Long id) {
        // 机构详情
        OgnInfoPojo ognInfoPojo = ognInfoRepository.getById(id);
        if (ognInfoPojo == null) {
            return ResultDo.build(MessageCodeConstant.ERROR_DATA_MISS);
        }
        // 机构banner列表
        List<BscFilePojo> ognBanners = bscFileRepository.getByBizTypeAndSourceId(BscFileBizType.organ_banner, id);
        // 机构课程列表
        List<OgnCoursePojo> ognCourses = ognCourseRepository.getByOgnId(id);
        OgnInfoDto ognInfoDto = new OgnInfoDto(ognInfoPojo, ognBanners, ognCourses);
        return ResultDo.build().setResult(ognInfoDto);
    }

}
