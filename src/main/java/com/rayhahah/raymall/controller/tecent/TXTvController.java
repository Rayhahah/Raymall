package com.rayhahah.raymall.controller.tecent;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rayhahah.raymall.common.Const;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.service.tecent.ITXTvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/12
 * @tips 这个类是Object的子类
 * @fuction 腾讯直播
 */
@Controller
@RequestMapping("/easysport/tecentcloud")
public class TXTvController {

    @Autowired
    private ITXTvService itxTvService;


    @RequestMapping(value = "get_push_url.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, String>> getPushUrl(String username, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return itxTvService.insertPushLive(username);
    }

    @RequestMapping(value = "get_current_live.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Map<String, String>>> getCurrentLive() {
        return itxTvService.getCurrentLive();
    }

    @RequestMapping(value = "callback_tecent.do", method = RequestMethod.POST)
    @ResponseBody
    public void callBackTencent(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject jo = new JsonParser().parse(sb.toString()).getAsJsonObject();
        int type = jo.get(Const.Tecent.EVENT_TYPE).getAsInt();
        if (Const.Tecent.EVENT_TYPE_BREAK.equals(type + "")) {
            String streamId = jo.get(Const.Tecent.STREAM_ID).getAsString();
            itxTvService.updateESLiveStatusByStreamId(streamId, type + "");
        } else if (Const.Tecent.EVENT_TYPE_PUSH.equals(type + "")) {
            String streamId = jo.get(Const.Tecent.STREAM_ID).getAsString();
            itxTvService.updateESLiveStatusByStreamId(streamId, type + "");
        } else if (Const.Tecent.EVENT_TYPE_RECORD.equals(type + "")) {
            String streamId = jo.get(Const.Tecent.STREAM_ID).getAsString();
            String videoUrl = jo.get(Const.Tecent.VIDEO_URL).getAsString();
            itxTvService.updateESLiveVideoByStreamId(streamId, videoUrl);
        } else if (Const.Tecent.EVENT_TYPE_SCREENSHOT.equals(type + "")) {
            String streamId = jo.get(Const.Tecent.STREAM_ID).getAsString();
            String picUrl = jo.get(Const.Tecent.PIC_URL).getAsString();
            itxTvService.updateESLivePicByStreamId(streamId, picUrl);
        }
    }

    // TODO: 2017/9/20 分页加载直播列表还没做

}
