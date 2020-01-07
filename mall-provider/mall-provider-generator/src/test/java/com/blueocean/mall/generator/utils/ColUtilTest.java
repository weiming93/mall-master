package com.blueocean.mall.generator.utils;

import com.blueocean.mall.generator.utils.ColUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ColUtilTest {

    @Test
    public void cloToJava(){
        assertThat(ColUtil.cloToJava("tinyint")).isEqualTo("Integer");
    }
}
