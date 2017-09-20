package com.rayhahah.raymall.service.easysport.impl;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.dao.ESCommentMapper;
import com.rayhahah.raymall.pojo.ESComment;
import com.rayhahah.raymall.service.easysport.IESCommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/11
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iESCommentService")
public class ESCommentServiceImpl implements IESCommentService {
    @Autowired
    private ESCommentMapper esCommentMapper;

    @Override
    public ServerResponse<String> commit(ESComment esComment) {
        if (StringUtils.isBlank(esComment.getComment())) {
            return ServerResponse.createByErrorMessage("反馈不能为空");
        }
        // TODO: 2017/9/11 用户id还没验证，等用户模块完善以后回来补上

        int count = esCommentMapper.insert(esComment);
        if (count > 0) {
            return ServerResponse.createBySuccess("提交反馈成功");
        }
        return ServerResponse.createByErrorMessage("提交反馈失败");
    }
}
