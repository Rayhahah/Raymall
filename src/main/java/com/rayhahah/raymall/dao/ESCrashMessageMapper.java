package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.ESCrashMessage;

public interface ESCrashMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ESCrashMessage record);

    int insertSelective(ESCrashMessage record);

    ESCrashMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ESCrashMessage record);

    int updateByPrimaryKey(ESCrashMessage record);
}