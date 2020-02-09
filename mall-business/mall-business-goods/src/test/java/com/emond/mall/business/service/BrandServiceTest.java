package com.emond.mall.business.service;

import com.emond.mall.provider.domain.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    private Brand brand;
    @BeforeEach
    public void setUp(){
        brand = new Brand();
        brand.setLetter("A");
        brand.setName("啊啊啊");
        brand.setSeq(1);
        brand.setImage("aaa.img");
    }

    @Test
    public void createTest(){
        Brand createBrand = brandService.save(this.brand).block();
        assertEquals(1,createBrand.getId());
    }

    @Test
    public void updateTest(){
        Brand createBrand = brandService.save(this.brand).block();
        createBrand.setName("aaa");
        Brand updateBrand = brandService.update(createBrand).block();
        assertEquals("aaa",updateBrand.getName());
    }
}
