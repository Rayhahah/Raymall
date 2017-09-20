package com.rayhahah.raymall.service.easysport;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.ESComment;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/11
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface IESCommentService {
    ServerResponse<String> commit(ESComment esComment);
}
