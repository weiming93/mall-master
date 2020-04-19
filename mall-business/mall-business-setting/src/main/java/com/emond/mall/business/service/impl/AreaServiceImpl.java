package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Area;
import com.emond.mall.business.repository.AreaRepository;
import com.emond.mall.business.service.AreaService;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import com.emond.mall.provider.setting.enums.AreaLevel;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {

    private final static String NAME = "地区";

    private final AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        super(areaRepository, NAME);
        this.areaRepository = areaRepository;
    }

    @Override
    public List<ElTree> findProvinceAndCityAndArea() {
        // TODO 使用缓存
        Integer level = AreaLevel.AREA.getLevel();
        List<Area> areasLevelAsc = areaRepository.findByLevelLessThanEqualOrderByLevelAsc(level);
        return buildTree(areasLevelAsc, level);
    }

    @Override
    public List<ElTree> findProvinceAndCity() {
        Integer level = AreaLevel.CITY.getLevel();
        List<Area> areasLevelAsc = areaRepository.findByLevelLessThanEqualOrderByLevelAsc(level);
        return buildTree(areasLevelAsc, level);
    }

    private List<ElTree> buildTree(List<Area> areasLevelAsc, Integer level) {
        List<ElTree> elTrees = new LinkedList<>();
        Map<Long, ElTree> map = new HashMap<>();
        for (Area area : areasLevelAsc) {
            ElTree elTree = ElTree.of(area.getId(), area.getName());
            Long pid = area.getPid();
            if (ObjectUtils.isEmpty(pid)) {
                // 加入省节点
                elTrees.add(elTree);
            } else {
                // 市/区 加入子树
                ElTree parent = map.get(pid);
                if (ObjectUtils.isEmpty(parent)) {
                    throw new ResourceNotFoundException("父节点", pid);
                }
                List<ElTree> children = parent.getChildren();
                children.add(elTree);
            }
            // 将 小于指定级别的节点加入map中
            if (area.getLevel() < level) {
                elTree.setChildren(new LinkedList<>());
                map.put(area.getId(), elTree);
            }
        }
        return elTrees;
    }

    @Override
    public List<ElTree> findProvince() {
        Integer level = AreaLevel.PROVINCE.getLevel();
        List<Area> areasLevelAsc = areaRepository.findByLevelLessThanEqualOrderByLevelAsc(level);
        List<ElTree> trees = areasLevelAsc.stream().map(area -> ElTree.of(area.getId(), area.getName())).collect(Collectors.toList());
        return trees;
    }
}
