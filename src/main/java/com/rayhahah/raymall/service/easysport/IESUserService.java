package com.rayhahah.raymall.service.easysport;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.ESUser;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/11
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface IESUserService {
    ServerResponse<ESUser> register(ESUser user);

    ServerResponse<ESUser> getUserInfo(String username, String password);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    ServerResponse<String> resetPassword(String username, String passwordOld, String passwordNew);

    ServerResponse<String> updateHupuInfo(String username, String password, String hupuUsername, String hupuPassword);

    ServerResponse<String> updateNormalInfo(String username, String password, String screenname, String email, String phone,String question,String answer);

    ServerResponse<String> updateCover(String username, String password, String cover);
}
