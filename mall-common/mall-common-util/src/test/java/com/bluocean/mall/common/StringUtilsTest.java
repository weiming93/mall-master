package com.bluocean.mall.common;

import com.emond.mall.common.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilsTest {

    @Test
    public void removePrefix(){
        String suffix = StringUtils.removePrefix("string", "str");
        assertThat(suffix).isEqualTo("ing");
    }
}
