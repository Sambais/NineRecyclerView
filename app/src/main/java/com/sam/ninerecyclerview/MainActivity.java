package com.sam.ninerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private RecyclerView recyclerview1;
    private int rowsnum=0;
    private List list;
    private List list1;
    private List<List> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview1 = (RecyclerView) findViewById(R.id.recyclerview1);
        lists = new ArrayList<>();
    }

    private void setPhoto() {
        list1 = new ArrayList<>();
        for (int i = 0; i <12; i++) {
            list1.add(R.drawable.bsj);
        }
    }

    private void setTitle() {
        for (int i = 0; i <7 ; i++) {
            list = new ArrayList<>();
            list.add("这个标题"+i);
            list.add(R.drawable.delete2);
            lists.add(list);
        }
    }

    private void setData() {
        setPhoto();

        setTitle();

        rowsnum=3;
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        NineTitleRecyclerviewAdapter adapter = new NineTitleRecyclerviewAdapter(lists);
        recyclerview.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerview1.setLayoutManager(layoutManager1);
        NinePhotoRecyclerviewAdapter adapter1=new NinePhotoRecyclerviewAdapter(MainActivity.this,list1);
        recyclerview1.setAdapter(adapter1);

    }


    private String getRandomLengthName(String name){
        Random random = new Random();
        int length= random.nextInt(20)+1;  // 产生1-20的随机数
        StringBuilder builder = new StringBuilder();
        for (int i =0;i<length;i++){
            builder.append(name);
        }
        return  builder.toString();
    }
}
