package com.zk.performance.memory.gc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zk.coreapi.utils.CommonUtil;
import com.zk.performance.memory.R;

/**
 * 关于JavaGC的主acitvity入口
 */
public class MemoryGcMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_gc_main);

        findViewById(R.id.comein_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.startActivity(MemoryGcMainActivity.this,MemoryReferenceOneActivity.class);
            }
        });
        findViewById(R.id.check_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("aaaaa","WeakRef :"+MemoryReferenceManager.getInstance().isWeakRefReRelease()
                +"==="+"SoftRef :"+MemoryReferenceManager.getInstance().isSoftRefReRelease());
            }
        });
        findViewById(R.id.add_mem_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoryReferenceManager.getInstance().addMemory(v.getContext());
            }
        });
        findViewById(R.id.release_mem_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemoryReferenceManager.getInstance().clearMemory();
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
