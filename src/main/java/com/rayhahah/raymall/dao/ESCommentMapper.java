package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.ESComment;

public interface ESCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ESComment record);

    int insertSelective(ESComment record);

    ESComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ESComment record);

    int updateByPrimaryKey(ESComment record);
}