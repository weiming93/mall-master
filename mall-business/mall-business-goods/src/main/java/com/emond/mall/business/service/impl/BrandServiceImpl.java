package com.emond.mall.business.service.impl;

import com.emond.mall.business.repository.BrandRepository;
import com.emond.mall.business.service.BrandService;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.provider.domain.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Flux<Brand> findAll() {
        return Flux
                .defer(() -> Flux.fromIterable(brandRepository.findAll()))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Page<Brand>> findPage(Pageable pageable) {
        return Mono
                .defer(() -> Mono.just(brandRepository.findAll(pageable)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Brand> findById(Long id) {
        return Mono
                .defer(() -> Mono.justOrEmpty(brandRepository.findById(id))
                        .switchIfEmpty(Mono.error(new ResourceNotFoundException("品牌", "id", id)))
                ).subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<Brand> save(Brand brand) {
        return Mono.just(brandRepository.save(brand));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<Brand> update(Brand brand) {
        return this.findById(brand.getId())
                .doOnSubscribe(b -> brandRepository.save(brand));
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
