package com.emond.mall.generator.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ColUtilTest {

    @Test
    public void cloToJava(){
        assertThat(ColUtil.cloToJava("tinyint")).isEqualTo("Integer");
    }
}
