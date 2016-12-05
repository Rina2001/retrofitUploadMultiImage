package com.rina.sampledrawerlayout_2;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private  String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str = getResources().getStringArray(R.array.arrays);
        drawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.left_drawer);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomerRecyclerAdapter(getApplicationContext(),str));
    }
}
