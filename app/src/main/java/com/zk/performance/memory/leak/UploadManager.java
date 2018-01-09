package com.zk.performance.memory.leak;

import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * Created by 099 on 2017/12/29.
 */

public class UploadManager {


    private A a;
//    private Map<View,IViewUploadListener> viewIViewListenerMap=new HashMap<>();
    private Map<View,IViewUploadListener> viewIViewListenerMap=new WeakHashMap<>();

    private static final UploadManager ourInstance = new UploadManager();

    private WeakReference<View> wf;

    public static UploadManager getInstance() {
        return ourInstance;
    }

    private UploadManager() {
        a=new A();
        B b=new B();
        C c=new C();
        D d=new D();
        a.b=b;
        a.c=c;
        b.d=d;
        c.d=d;

    }

    /**
     * 添加监听器
     * @param view
     * @param listener
     */
    public synchronized  void addListener(View view,IViewUploadListener listener){
        viewIViewListenerMap.put(view,listener);
    }
    public synchronized void removeListener(View view,IViewUploadListener listener){
        viewIViewListenerMap.remove(view);
    }
    public synchronized void clear(){
        viewIViewListenerMap.clear();
    }

    /**
     * 通知上传完成
     */
    public synchronized void notifyUploadFinished() {
        if (viewIViewListenerMap.isEmpty()) {
            for (Map.Entry<View,IViewUploadListener> entry:viewIViewListenerMap.entrySet()) {
                entry.getValue().viewUploadSuccess();
            }
        }
    }
    /**
     * 通知上传完成
     */
    public synchronized void notifyUploadFinished(View view) {


        if (!viewIViewListenerMap.isEmpty()) {
            IViewUploadListener listener=viewIViewListenerMap.get(view);
            if (listener!=null){
                listener.viewUploadSuccess();
            }
        }

    }
    public void printMap(){
        if(!viewIViewListenerMap.isEmpty()){
            for(Map.Entry<View,IViewUploadListener> entry:viewIViewListenerMap.entrySet()){
                View key=entry.getKey();
                IViewUploadListener value=entry.getValue();
                Log.e("aaa",key.toString()+":"+value.toString());
            }
        }

    }

}
