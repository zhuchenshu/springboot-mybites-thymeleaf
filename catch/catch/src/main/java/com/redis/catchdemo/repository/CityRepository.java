package com.redis.catchdemo.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/28
 * * Time: 10:24
 * * Description:
 */
public interface CityRepository extends CrudRepository<City, String> {
    Optional<City> findById(String id);
    City findCityById(String id);
}
