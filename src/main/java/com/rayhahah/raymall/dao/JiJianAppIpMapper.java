package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.JiJianAppIp;
import org.apache.ibatis.annotations.Param;

public interface JiJianAppIpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JiJianAppIp record);

    int insertSelective(JiJianAppIp record);

    JiJianAppIp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JiJianAppIp record);

    int updateByPrimaryKey(JiJianAppIp record);

    JiJianAppIp queryByName(@Param("name") String name);
}