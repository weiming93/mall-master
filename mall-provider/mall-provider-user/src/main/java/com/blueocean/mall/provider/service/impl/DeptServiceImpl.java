package com.blueocean.mall.provider.service.impl;

import com.blueocean.mall.common.exception.BadRequestException;
import com.blueocean.mall.common.exception.ResourceNotFoundException;
import com.blueocean.mall.provider.domain.Dept;
import com.blueocean.mall.provider.repository.DeptRepository;
import com.blueocean.mall.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dept create(Dept dept) {
        return deptRepository.save(dept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Dept dept) {
        if (dept.getId().equals(dept.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        deptRepository.findById(dept.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Dept","id",dept.getId()));
        deptRepository.save(dept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        deptRepository.deleteById(id);
    }
}