package com.blueocean.mall.generator.service;

import com.blueocean.mall.generator.domain.GenConfig;
import com.blueocean.mall.generator.payload.ColumnProjection;
import com.blueocean.mall.generator.payload.TableProjection;
import com.blueocean.mall.generator.service.GeneratorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class GeneratorConfigServiceTest {

    @Autowired
    private GeneratorService genConfigService;

    GenConfig genConfig;

    @BeforeEach
    public void setUp() {
        genConfig = new GenConfig();
        genConfig.setAuthor("Chen Weiming");
        genConfig.setCover(false);
        genConfig.setModuleName("mall-provider-generator");
        genConfig.setPack("com.blueocean.mall.provider");
        genConfig.setPath("E:\\\\workspace\\\\me\\\\front\\\\eladmin-qt\\\\src\\\\views");
        genConfig.setApiPath("E:\\\\workspace\\\\me\\\\front\\\\eladmin-qt\\\\src\\\\api");
    }

    @Test
    public void find() {
        genConfigService.create(genConfig);
        assertThat(genConfigService.find().getId()).isEqualTo(1L);
    }

    @Test
    public void findPagedTableProjectedByTableName() {
        Page<TableProjection> page = genConfigService.findPagedTableProjectedByTableName(null,
                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "create_time")));
        assertThat(page.getContent().get(0).getTableName()).isEqualTo("gen_config");
    }

    @Test
    public void findColumnProjectionsByTableName() {
        List<ColumnProjection> columns = genConfigService.findColumnProjectionsByTableName("gen_config");
        Assertions.assertEquals(10, columns.size());
    }
}
