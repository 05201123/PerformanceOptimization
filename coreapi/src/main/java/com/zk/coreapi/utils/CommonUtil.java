package com.zk.coreapi.utils;

import android.content.Context;
import android.content.Intent;

/**
 * 基础工具类
 * Created by 099 on 2018/1/10.
 */

public class CommonUtil {
    /**
     * 跳转到Activity
     * @param context
     * @param clazz
     */
    public static void startActivity(Context context,Class<?> clazz){
        Intent intent=new Intent(context,clazz);
        context.startActivity(intent);
    }
}
