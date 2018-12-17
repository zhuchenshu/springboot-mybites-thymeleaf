package com.mybites.demo.properties;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/16
 * * Time: 20:22
 * * Description:
 */
@Configuration
public class MybatisConfiguration{

    @Bean
    public PageHelper pageHelper(){
        System.out.print("pageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");

        pageHelper.setProperties(properties);

        return pageHelper;
    }
}
