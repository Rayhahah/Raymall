package com.rayhahah.raymall.service.tecent;

import com.rayhahah.raymall.common.ServerResponse;

import java.util.List;
import java.util.Map;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/12
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface ITXTvService {
    ServerResponse<Map<String,String>> insertPushLive(String username);

    ServerResponse<List<Map<String, String>>> getCurrentLive();

    void updateESLiveStatusByStreamId(String steamId, String status);

    void updateESLivePicByStreamId(String streamId, String picUrl);

    void updateESLiveVideoByStreamId(String streamId, String videoUrl);
}
