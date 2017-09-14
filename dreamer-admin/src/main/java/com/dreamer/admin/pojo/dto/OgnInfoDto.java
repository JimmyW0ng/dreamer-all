package com.dreamer.admin.pojo.dto;

import com.dreamer.admin.pojo.AbstractBasePojo;
import com.dreamer.admin.pojo.po.BscFilePojo;
import com.dreamer.admin.pojo.po.OgnInfoPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by J.W on 2017/9/14 0014.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OgnInfoDto extends AbstractBasePojo {

    private OgnInfoPojo ognInfoPojo;
    private List<BscFilePojo> bscFilePojo;

}
