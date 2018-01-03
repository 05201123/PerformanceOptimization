package com.zk.performance.memory.leak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zk.performance.memory.R;

/**
 * 监听器引起的内存泄漏
 * 需求：有一个图片上传的功能，模拟选中几张图片，上传图片到服务器，
 * 当一张上传成功之后，将这张图片从当前页面中隐藏掉。
 */
public class MemoryLeakOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak_one);
        UploadManager.getInstance().addListener(findViewById(R.id.imageView), new IViewUploadListener() {
                    @Override
                    public void viewUploadSuccess() {

                    }
                }
        );
        UploadManager.getInstance().addListener(findViewById(R.id.imageView2), new IViewUploadListener() {
                    @Override
                    public void viewUploadSuccess() {

                    }
                }
        );
        UploadManager.getInstance().addListener(findViewById(R.id.imageView3), new IViewUploadListener() {
                    @Override
                    public void viewUploadSuccess() {
                        findViewById(R.id.imageView2).setVisibility(View.GONE);
                    }
                }
        );
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadManager.getInstance().notifyUploadFinished(findViewById(R.id.imageView3));
            }
        });

    }
}
