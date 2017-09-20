package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.ESLive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ESLiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ESLive record);

    int insertSelective(ESLive record);

    ESLive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ESLive record);

    int updateByPrimaryKey(ESLive record);

    List<ESLive> queryAllLiveByStatus(@Param("liveStatus") String liveStatus);

    ESLive queryLiveByUsername(@Param("liveStatus") String username);

    int updateStatusByStreamId(@Param("streamId") String steamId, @Param("status") String status);

    int updatePicUrlByStreamId(@Param("streamId") String streamId, @Param("picUrl") String picUrl);

    int updateVideoUrlByStreamId(@Param("streamId") String streamId,@Param("videoUrl") String videoUrl);
}