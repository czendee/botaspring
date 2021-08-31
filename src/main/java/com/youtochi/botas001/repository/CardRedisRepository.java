package com.youtochi.botas001.repository;

import org.springframework.data.repository.CrudRepository;
import com.youtochi.botas001.CardRedis;

@Repository
public interface CardRedisRepository extends CrudRepository<CardRedis, String> {}
