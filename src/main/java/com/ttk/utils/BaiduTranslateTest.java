package com.ttk.utils;

public class BaiduTranslateTest {
    public static void main(String[] args) {
        BaiduTranslate bt = BaiduTranslate.getInstance();
        String str = bt.translate("中国", BaiduTranslate.AUTO, BaiduTranslate.EN);
        System.out.println(str);
    }
}
