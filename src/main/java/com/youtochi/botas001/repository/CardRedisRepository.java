package com.youtochi.botas001.repository;

import org.springframework.data.repository.CrudRepository;
import com.youtochi.botas001.model.CardRedis;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRedisRepository extends CrudRepository<CardRedis, String> {}
