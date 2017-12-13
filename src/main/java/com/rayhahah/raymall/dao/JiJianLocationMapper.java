package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.JiJianLocation;

public interface JiJianLocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JiJianLocation record);

    int insertSelective(JiJianLocation record);

    JiJianLocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JiJianLocation record);

    int updateByPrimaryKey(JiJianLocation record);
}