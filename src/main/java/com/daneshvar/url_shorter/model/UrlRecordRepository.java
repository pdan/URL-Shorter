package com.daneshvar.url_shorter.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRecordRepository extends CrudRepository<UrlRecord, Long> {

    @Override
    Optional<UrlRecord> findById(Long id);

    @Override
    Iterable<UrlRecord> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends UrlRecord> S save(S entity);

    UrlRecord findByKey(String key);
}
