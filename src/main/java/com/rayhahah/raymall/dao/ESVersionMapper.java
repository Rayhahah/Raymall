package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.ESVersion;

public interface ESVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ESVersion record);

    int insertSelective(ESVersion record);

    ESVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ESVersion record);

    int updateByPrimaryKey(ESVersion record);
}