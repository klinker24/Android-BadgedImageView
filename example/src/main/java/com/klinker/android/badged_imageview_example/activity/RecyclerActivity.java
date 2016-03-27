package com.klinker.android.badged_imageview_example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.klinker.android.badged_imageview_example.R;
import com.klinker.android.badged_imageview_example.adapter.TestAdapter;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyler = (RecyclerView) findViewById(R.id.recyler);
        recyler.setLayoutManager(new GridLayoutManager(this, 2));
        recyler.setAdapter(new TestAdapter());
    }
}
