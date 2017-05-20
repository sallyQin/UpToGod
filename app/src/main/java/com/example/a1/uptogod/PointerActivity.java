package com.example.a1.uptogod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class PointerActivity extends AppCompatActivity {
    RecyclerView pointer_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pointer);
        pointer_recyclerView = (RecyclerView) findViewById(R.id.pointer_recyclerView);
        PointerAdapter.pointerActivity = this;
        pointer_recyclerView.setAdapter(new PointerAdapter(R.layout.recyclerview_pointer_setting));
    }
}
