package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.NetSourceComic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NetSourceComicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NetSourceComic record);

    int insertSelective(NetSourceComic record);

    NetSourceComic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NetSourceComic record);

    int updateByPrimaryKey(NetSourceComic record);


    List<NetSourceComic> query(@Param("id") Integer id,
                               @Param("from") String from,
                               @Param("title") String title,
                               @Param("author") String author,
                               @Param("category") String category,
                               @Param("status") String status,
                               @Param("label") String label);
}