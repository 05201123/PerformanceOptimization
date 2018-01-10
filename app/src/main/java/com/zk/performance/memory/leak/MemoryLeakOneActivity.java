package com.zk.performance.memory.leak;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zk.performance.memory.R;

import java.io.IOException;

/**
 * 监听器引起的内存泄漏
 * 需求：有一个图片上传的功能，模拟选中几张图片，上传图片到服务器，
 * 当一张上传成功之后，将这张图片从当前页面中隐藏掉。
 * 关于weakHashMap的运用。
 */
public class MemoryLeakOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak_one);
        UploadManager.getInstance().addListener(findViewById(R.id.imageView3), new ViewUploadListenerImpl());

//        MemoryReferenceManager.getInstance().addListener(findViewById(R.id.imageView3), new IViewUploadListener() {
//                    @Override
//                    public void viewUploadSuccess() {
//                        findViewById(R.id.imageView2).setVisibility(View.GONE);
//                    }
//                }
//        );
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadManager.getInstance().notifyUploadFinished(findViewById(R.id.imageView3));
            }
        });

    }

    @Override
    protected void onDestroy() {
//        try {
//            Debug.dumpHprofData("/sdcard/dump.hprof");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        super.onDestroy();
    }
    public static class ViewUploadListenerImpl implements   IViewUploadListener{

        @Override
        public void viewUploadSuccess() {

        }
    }
}
