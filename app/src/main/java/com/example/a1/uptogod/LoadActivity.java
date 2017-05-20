package com.example.a1.uptogod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class LoadActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerV_load);
        LoadAdapter.loadActivity = this;
        LoadAdapter loadAdapter = new LoadAdapter();
        getSupportLoaderManager().restartLoader(0,null,loadAdapter);
        recyclerView.setAdapter(loadAdapter);
    }
}
