package com.zk.performance.memory.gc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zk.performance.memory.R;

/**
 * 内存四种引用类型 StrongReference，WeakReference，SoftReference
 */
public class MemoryReferenceOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_reference_one);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoryReferenceManager.getInstance().setWeakReferenceView(v);
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoryReferenceManager.getInstance().setSoftReferenceView(v);
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

}
