package com.hobbou.app;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hobbou.app.Adapter.CategoryAdapter;
import com.hobbou.app.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRV;
    CategoryAdapter categoryAdapter;
    List<Category> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        categoryRV = (RecyclerView) findViewById(R.id.category_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRV.setLayoutManager(linearLayoutManager);
        categories = initializeCategory(15);
        categoryAdapter = new CategoryAdapter(categories);
        categoryRV.setAdapter(categoryAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchMenu = menu.findItem(R.id.action_search);
        MenuItem userMenu = menu.findItem(R.id.action_user);
        try {
            searchMenu.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            userMenu.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        } catch (Exception e){

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_search:
                break;
            case R.id.action_user:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    private List<Category> initializeCategory(int number){
        List<Category> newCategories = new ArrayList<>();
        for (int i=0; i<number;i++){
            Category category = new Category();
            category.setName("categ");
            category.setId(number);
            category.setSequence(number);
            newCategories.add(category);
        }
        return newCategories;
    }
}
