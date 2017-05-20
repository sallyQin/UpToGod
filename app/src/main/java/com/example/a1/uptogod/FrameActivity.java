package com.example.a1.uptogod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class FrameActivity extends AppCompatActivity {
    RecyclerView frame_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        frame_recyclerView = (RecyclerView) findViewById(R.id.frame_recyclerView);
        FrameAdapter.frameActivity = this;
        frame_recyclerView.setAdapter(new FrameAdapter(R.layout.recyclerview_frame_setting) );
    }
}
