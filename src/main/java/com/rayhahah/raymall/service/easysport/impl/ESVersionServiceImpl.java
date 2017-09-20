package com.rayhahah.raymall.service.easysport.impl;

import com.rayhahah.raymall.dao.ESVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
@Service("iESVersionService")
public class ESVersionServiceImpl {

    @Autowired
    private ESVersionMapper esVersionMapper;

}
