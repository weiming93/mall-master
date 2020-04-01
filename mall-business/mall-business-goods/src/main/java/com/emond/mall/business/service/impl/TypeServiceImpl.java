package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Attribute;
import com.emond.mall.business.domain.Type;
import com.emond.mall.business.repository.TypeRepository;
import com.emond.mall.business.service.TypeService;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TypeServiceImpl extends BaseServiceImpl<Type> implements TypeService {

    private final static String NAME = "商品类型";

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        super(typeRepository, NAME);
        this.typeRepository = typeRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Type create(Type resource) {
        if (typeRepository.existsByName(resource.getName())) {
            throw new EntityExistException(NAME, resource.getName());
        }
        return super.create(resource);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Type update(Type resource) {
        if (typeRepository.existsByNameAndIdNot(resource.getName(), resource.getId())) {
            throw new EntityExistException(NAME, resource.getName());
        }
        return super.update(resource);
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public List<ElTree> getCascaderAttribute() {
        List<ElTree> elTrees = new ArrayList<>();
        // 查询所有商品类型
        List<Type> types = typeRepository.findAll();
        for (Type type : types) {
            ElTree elTree = ElTree.of(type.getId(), type.getName());

            if (ObjectUtils.isNotEmpty(type.getAttributes())){
                List<ElTree> children = new ArrayList<>();
                // 添加商品类型下的所有属性
                for (Attribute attribute : type.getAttributes()) {
                    ElTree child = ElTree.of(attribute.getId(), attribute.getName());
                    children.add(child);
                }
                elTree.setChildren(children);
            }
            elTrees.add(elTree);
        }
        return elTrees;
    }
}
