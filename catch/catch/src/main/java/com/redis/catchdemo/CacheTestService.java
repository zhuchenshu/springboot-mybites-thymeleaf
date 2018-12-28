package com.redis.catchdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/27
 * * Time: 21:58
 * * Description:
 */
@Service
public class CacheTestService {
    final static Log log = LogFactory.getLog(CacheTestService.class);

    @Cacheable(value = "getData")
    public String getData() {
        System.out.println("=====看见这句话，表示你没有读取缓存数据====");
        return "当前系统时间搓" + System.currentTimeMillis();
    }

}
