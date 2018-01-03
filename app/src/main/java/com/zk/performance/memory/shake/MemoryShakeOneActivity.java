package com.zk.performance.memory.shake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zk.performance.memory.R;

import java.util.ArrayList;
import java.util.List;

public class MemoryShakeOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_shake_one);
        findViewById(R.id.memory_shake_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person> personList=new ArrayList<>();
                for (int i=10000;i>0;i--){
                    Person person=new Person();
                    person.setName(i+"");
                    personList.add(person);
                }

            }
        });
    }
}
