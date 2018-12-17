package com.mybites.demo.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * * Created with IntelliJ IDEA.
 * * User: zhuchenshu
 * * Date: 2018/12/16
 * * Time: 20:24
 * * Description:
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
