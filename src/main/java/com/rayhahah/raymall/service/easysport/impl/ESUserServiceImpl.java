package com.rayhahah.raymall.service.easysport.impl;

import com.rayhahah.raymall.common.Const;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.common.TokenCache;
import com.rayhahah.raymall.dao.ESUserMapper;
import com.rayhahah.raymall.pojo.ESUser;
import com.rayhahah.raymall.service.easysport.IESUserService;
import com.rayhahah.raymall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/11
 * @tips 这个类是Object的子类
 * @fuction
 */

@Service("iESUserService")
public class ESUserServiceImpl implements IESUserService {

    @Autowired
    private ESUserMapper esUserMapper;

    /**
     * 注册新用户
     *
     * @param user
     * @return
     */
    @Override
    public ServerResponse<ESUser> register(ESUser user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return ServerResponse.createByErrorMessage("用户名不能为空");
        }
        String password = user.getPassword();
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createByErrorMessage("密码不能为空");
        }
        if (StringUtils.isBlank(user.getScreenname())) {
            return ServerResponse.createByErrorMessage("昵称不能为空");
        }
        if (StringUtils.isBlank(user.getQuestion())) {
            return ServerResponse.createByErrorMessage("寻回问题不能为空");
        }
        if (StringUtils.isBlank(user.getAnswer())) {
            return ServerResponse.createByErrorMessage("寻回答案不能为空");
        }
        if (!checkValid(user.getUsername(), Const.USERNAME).isSuccess()) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(password));
        if (StringUtils.isNotBlank(user.getHupuPassword())) {
            user.setHupuPassword(user.getHupuPassword());
        }
        int count = esUserMapper.insert(user);
        if (count > 0) {
            return getUserInfo(user.getUsername(), password);
        }
        return ServerResponse.createByErrorMessage("注册用户失败");
    }

    /**
     * 获取用户信息
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public ServerResponse<ESUser> getUserInfo(String username, String password) {
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createByErrorMessage("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createByErrorMessage("密码不能为空");
        }
        ESUser esUser = esUserMapper.queryByUsername(username);
        if (esUser != null && esUser.getPassword().equals(MD5Util.MD5EncodeUtf8(password))) {
            esUser.setPassword(password);
            return ServerResponse.createBySuccess("操作成功", esUser);
        }
        return ServerResponse.createByErrorMessage("获取用户信息失败");
    }

    /**
     * 检查用户名或邮箱是否唯一
     *
     * @param str
     * @param type
     * @return
     */
    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            //开始校验
            if (Const.USERNAME.equals(type)) {
                int resultCount = esUserMapper.checkUsername(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int resultCount = esUserMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    /**
     * 获取重置密码的问题
     *
     * @param username
     * @return
     */
    @Override
    public ServerResponse<String> selectQuestion(String username) {
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (validResponse.isSuccess()) {
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在的");
        }
        String question = esUserMapper.selectQuestionByUsername(username);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(question)) {
            return ServerResponse.createBySuccess(question);
        }
        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    /**
     * 检查问题是否正确
     *
     * @param username
     * @param question
     * @param answer
     * @return
     */
    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int resultCount = esUserMapper.checkAnswer(username, question, answer);
        if (resultCount > 0) {
            //说明问题及问题答案是这个用户的,并且是正确的
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题的答案错误");
    }

    /**
     * 忘记密码的重置密码
     *
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    @Override
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        if (StringUtils.isBlank(forgetToken)) {
            return ServerResponse.createByErrorMessage("参数错误,token需要传递");
        }
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (validResponse.isSuccess()) {
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
        if (StringUtils.isBlank(token)) {
            return ServerResponse.createByErrorMessage("token无效或者过期");
        }

        if (StringUtils.equals(forgetToken, token)) {
            String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
            int rowCount = esUserMapper.updatePasswordByUsername(username, md5Password);

            if (rowCount > 0) {
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("token错误,请重新获取重置密码的token");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    /**
     * 重置密码
     *
     * @param username
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @Override
    public ServerResponse<String> resetPassword(String username, String passwordOld, String passwordNew) {
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createByErrorMessage("用户名不能为空");
        }
        if (StringUtils.isBlank(passwordOld)) {
            return ServerResponse.createByErrorMessage("旧密码不能为空");
        }
        if (StringUtils.isBlank(passwordNew)) {
            return ServerResponse.createByErrorMessage("新密码不能为空");
        }

        ServerResponse<ESUser> user = getUserInfo(username, passwordOld);
        if (user.isSuccess()) {
            ESUser userData = user.getData();
            userData.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
            int count = esUserMapper.updatePasswordByUsername(userData.getUsername(), userData.getPassword());
            if (count > 0) {
                return ServerResponse.createBySuccess("更新密码成功");
            }
        }
        return ServerResponse.createByErrorMessage("账号或旧密码错误");
    }

    @Override
    public ServerResponse<String> updateHupuInfo(String username, String password, String hupuUsername, String hupuPassword) {
        ServerResponse<ESUser> userInfo = getUserInfo(username, password);
        if (userInfo.isSuccess()) {
            int count = esUserMapper.updateHupuByUsername(username, hupuUsername, hupuPassword);
            if (count > 0) {
                return ServerResponse.createBySuccess("设置信息成功");
            }
        }
        return ServerResponse.createByErrorMessage("设置信息失败");
    }

    @Override
    public ServerResponse<String> updateNormalInfo(String username, String password, String screenname, String email, String phone, String question, String answer) {
        ServerResponse<ESUser> userInfo = getUserInfo(username, password);
        if (userInfo.isSuccess()) {
            ESUser user = userInfo.getData();
            user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
            if (StringUtils.isNotBlank(screenname)) {
                user.setScreenname(screenname);
            }
            if (StringUtils.isNotBlank(email)) {
                user.setEmail(email);
            }
            if (StringUtils.isNotBlank(phone)) {
                user.setPhone(phone);
            }
            if (StringUtils.isNotBlank(question)) {
                user.setQuestion(question);
            }
            if (StringUtils.isNotBlank(answer)) {
                user.setAnswer(answer);
            }
            int count = esUserMapper.updateByPrimaryKeySelective(user);
            if (count > 0) {
                return ServerResponse.createBySuccess("设置信息成功");
            }
        }
        return ServerResponse.createByErrorMessage("设置信息失败");
    }

    @Override
    public ServerResponse<String> updateCover(String username, String password, String cover) {
        if (StringUtils.isBlank(cover)) {
            return ServerResponse.createByErrorMessage("上传头像失败");
        }
        ServerResponse<ESUser> userInfo = getUserInfo(username, password);
        if (userInfo.isSuccess()) {
            int count = esUserMapper.updateCoverByUsername(username, cover);
            if (count > 0) {
                return ServerResponse.createBySuccess("上传头像成功", cover);
            }
        }
        return ServerResponse.createByErrorMessage("上传头像失败");
    }


}
