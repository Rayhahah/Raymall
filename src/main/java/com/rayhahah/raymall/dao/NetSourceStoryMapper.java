package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.NetSourceStory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NetSourceStoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NetSourceStory record);

    int insertSelective(NetSourceStory record);

    NetSourceStory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NetSourceStory record);

    int updateByPrimaryKey(NetSourceStory record);

    List<NetSourceStory> query(@Param("id")Integer id,
                               @Param("from")String from,
                               @Param("title")String title,
                               @Param("content")String content,
                               @Param("category")String category,
                               @Param("label")String label);
}