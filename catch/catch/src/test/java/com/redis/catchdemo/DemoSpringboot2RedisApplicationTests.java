package com.redis.catchdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/27
 * * Time: 21:59
 * * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringboot2RedisApplicationTests {

    @Autowired
    CacheTestService cacheTestService;

    @Test
    public void cacheTest() {
        for (int i=0;i<5;i++){
            System.out.println(cacheTestService.getData());
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
