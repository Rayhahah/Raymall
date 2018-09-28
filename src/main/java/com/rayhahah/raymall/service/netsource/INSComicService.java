package com.rayhahah.raymall.service.netsource;

import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.ServerResponse;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface INSComicService {

    ServerResponse<PageInfo> query(int id, String from, String title, String author, String category, String status, String label, int pageNum, int pageSize, String orderBy);
}
