package com.example.a1.uptogod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class BackgroundActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        recyclerView = (RecyclerView) findViewById(R.id.bg_recyclerView);
        BackgroundAdapter.backgroundActivity = this;
        recyclerView.setAdapter(new BackgroundAdapter(R.layout.recyclerview_background_setting));
    }
}
