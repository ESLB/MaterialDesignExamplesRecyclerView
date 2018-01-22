package com.pruebas.elsve.materialdesignexamplesrecyclerview.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pruebas.elsve.materialdesignexamplesrecyclerview.R;

import adapter.RecyclerAdapter;
import model.Landscape;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();


    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);


        //Para usar los otros tipos
        //Horizontal
        //GridLayoutManager mGridLayout = new GridLayout(this, 3); recyclerView.setLayoutManager(mGridLayout);
        //StaggerGridLayoutManager mStaggerGridLayoutManager = new StaggerGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        //También puede ser VERTICAL

    }
}
