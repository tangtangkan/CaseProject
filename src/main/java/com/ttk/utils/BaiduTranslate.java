package com.ttk.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Random;

/**
 * @version 1.0.0
 * 通过调用百度翻译openapi完成翻译功能，更多语种的翻译可参阅：http://fanyi-api.baidu.com/api/trans/product/apidoc
 */
public class BaiduTranslate {

    /**
     * 自动检测语言
     */
    public static final String AUTO = "auto";

    /**
     * 中文
     */
    public static final String ZH = "zh";

    /**
     * 英语
     */
    public static final String EN = "en";

    /**
     * 繁体中文
     */
    public static final String CHT = "cht";

    /**
     * 要翻译的词条
     */
    private String q;
    private String from;
    private String to;

    /**
     * 百度翻译开发者信息的APP ID
     * 上面图片上的APP ID
     */
    private final String APPID = "20220915001344024";

    private String salt = new Random().nextInt(99999) + "";
    /**
     * 百度翻译开发者信息的密钥：上面图片上的密钥
     */
    private final String KEY = "6XOeXRluYqlfoUlN6YeG";

    private String sign;

    private String url;

    private static BaiduTranslate bt = new BaiduTranslate();

    private BaiduTranslate() {
    }

    /**
     * @return BT, 获取本类实例
     */
    public static BaiduTranslate getInstance() {
        return bt;
    }

    /**
     * @param word：要翻译的词条
     * @param from：源语种
     * @param to：目标语种
     * @return 获取翻译的结果
     */
    public String translate(String word, String from, String to) {
        this.q = word;
        this.from = from;
        this.to = to;
        this.sign = MD5Util.md5(APPID + this.q + salt + KEY);
        this.url = "http://api.fanyi.baidu.com/api/trans/vip/translate?q=" + this.q + "&from=" + this.from + "&to=" + this.to + "&appid=" + APPID + "&salt=" + this.salt + "&sign=" + this.sign;
        String result = null;
        try {
            result = doGet(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("发送doGet请求时，出现错误");
        }
        return result;
    }

    /**
     * @param url 调用百度翻译openapi的url
     * @return 返回的字符串结果
     * @throws IOException
     */
    private String doGet(String url) throws IOException {
        String body = HttpUtil.createGet(url).execute().body();
        JSONObject jsonObject = (JSONObject) JSON.parse(body);
        JSONArray jsonArray = (JSONArray) jsonObject.get("trans_result");
        JSONObject result = (JSONObject) jsonArray.get(0);
        return result.get("dst").toString();
    }
}

