package com.rayhahah.raymall.dao;

import com.rayhahah.raymall.pojo.ESUser;
import org.apache.ibatis.annotations.Param;

public interface ESUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ESUser record);

    int insertSelective(ESUser record);

    ESUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ESUser record);

    int updateByPrimaryKey(ESUser record);

    ESUser queryByUsername(@Param("username") String username);

    int checkUsername(String username);

    int checkEmail(String email);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    int updateHupuByUsername(@Param("username") String username,@Param("hupuUsername") String hupuUsername,@Param("hupuPassword") String hupuPassword);

    int updateCoverByUsername(@Param("username") String username,@Param("cover") String cover);
}