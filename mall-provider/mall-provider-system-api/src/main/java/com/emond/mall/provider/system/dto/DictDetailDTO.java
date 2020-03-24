package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import lombok.Data;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
public class DictDetailDTO extends BaseDTO {

    private String label;

    private String value;

    private String sort;

}
