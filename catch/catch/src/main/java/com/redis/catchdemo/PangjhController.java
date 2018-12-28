package com.redis.catchdemo;

import com.redis.catchdemo.repository.City;
import com.redis.catchdemo.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class PangjhController {
    private final static Logger logger = LoggerFactory.getLogger(PangjhController.class);
    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/setValue")
    public String setValue(){
        if(!template.hasKey("shabao")){
            template.opsForValue().append("test1", "123123");
            return "使用redis缓存保存数据成功";
        }else{
            template.delete("shabao");
            return "key已存在";
        }
    }

    @RequestMapping("/getValue")
    public String getValue(){
        if(!template.hasKey("shabao")){
            return "key不存在，请先保存数据";
        }else{
            String shabao = template.opsForValue().get("shabao");//根据key获取缓存中的val
            return "获取到缓存中的数据：shabao="+shabao;
        }
    }

    @RequestMapping("/log")
    public void testLog() {
        logger.info("info");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
    }

    @GetMapping("/getCity/{id}")
    @Cacheable(value = "City" , key = "#p0")
    public City getCityById(@PathVariable String id) {
        logger.info("这是一个info日志...");
        return cityRepository.findCityById(id);
    }

    @GetMapping("/updateCity")
    @CacheEvict(value = "City", key = "#p0.getId()")
    public void updateCity(City city) {
        City city1 = cityRepository.findCityById(city.getId());
        city1.setName(city.getName());
        city1.setState(city.getState());
        cityRepository.save(city1);
    }

    @PostMapping("/addCity")
    @Cacheable(value = "City" , key = "#p0.getName()")
    public City addCity(City city) {
        return cityRepository.save(city);
    }
}

