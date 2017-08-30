package com.jaydenxiao.common.commonutils;

import com.orhanobut.hawk.Hawk;

/**
 * Created by Administrator on 2017/3/22.
 */

public class HawkUtil {
    private static String TIME = "_time";
    //    public static <T> boolean put(String key, T code) {
    //        return hawkFacade.put(key, code);
    //    }

    /**
     * @param key
     * @param value
     * @param saveTime 单位 秒
     * @param <T>
     * @return
     */
    public static <T> boolean put(String key, T value, int saveTime) {
        boolean put = Hawk.put(key, value);
        long time = saveTime + System.currentTimeMillis() / 1000;
        Hawk.put(key + TIME, time);
        return put;
    }

    public static <T> T get(String key) {
        Long lastTime = Hawk.get(key + TIME);
        if (null != lastTime) {
            long currentTime = System.currentTimeMillis() / 1000;
            if (currentTime - lastTime < 0) {
                return Hawk.get(key);
            } else {
                return null;
            }
        } else {
            return Hawk.get(key);
        }
    }
}
