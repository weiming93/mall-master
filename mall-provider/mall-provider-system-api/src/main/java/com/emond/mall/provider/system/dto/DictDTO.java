package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
public class DictDTO extends BaseDTO {

    private String name;

    private String remark;

    private List<DictDetailDTO> dictDetails;

}
