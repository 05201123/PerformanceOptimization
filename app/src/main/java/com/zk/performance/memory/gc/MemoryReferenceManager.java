package com.zk.performance.memory.gc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.zk.performance.memory.R;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 引用Manager
 * Created by 099 on 2017/1/10
 */

public class MemoryReferenceManager {

    private static final MemoryReferenceManager ourInstance = new MemoryReferenceManager();

    private WeakReference<View> weakRef;

    private SoftReference<View> softRef;

    private List<Bitmap> cacheMemoryBitMap=new ArrayList<>();

    public static MemoryReferenceManager getInstance() {
        return ourInstance;
    }

    private MemoryReferenceManager() {

    }

    /**
     * 设置缓存的view,弱引用
     *
     * @param view
     */
    public void setWeakReferenceView(View view) {
        weakRef = new WeakReference<View>(view);
    }

    /**
     * 弱引用是否释放
     *
     * @return
     */
    public boolean isWeakRefReRelease() {
        return weakRef != null && weakRef.get() == null;
    }

    /**
     * 设置缓存的view,软引用
     *
     * @param view
     */
    public void setSoftReferenceView(View view) {

        softRef = new SoftReference<View>(view);
    }

    /**
     * 软引用是否释放
     *
     * @return
     */
    public boolean isSoftRefReRelease() {
        return softRef != null && softRef.get() == null;
    }

    /**
     * 增加内存
     */
    public void addMemory(Context context) {
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.button1);
        cacheMemoryBitMap.add(bitmap);
    }

    /***
     * 清空内存
     */
    public void clearMemory(){
        cacheMemoryBitMap.clear();
    }
}
