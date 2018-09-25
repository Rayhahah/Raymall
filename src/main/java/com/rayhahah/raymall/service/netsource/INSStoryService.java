package com.rayhahah.raymall.service.netsource;

import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.NetSourceStory;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/19
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface INSStoryService {
    ServerResponse<NetSourceStory> add(NetSourceStory story);

    ServerResponse<NetSourceStory> update(NetSourceStory story);

    ServerResponse<String> delete(int id);

    ServerResponse<PageInfo> query(int id, String from, String title, String content, String category, String label, int pageNum, int pageSize, String orderBy);
}
