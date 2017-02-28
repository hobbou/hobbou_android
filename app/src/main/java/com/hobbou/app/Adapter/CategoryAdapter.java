package com.hobbou.app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hobbou.app.Model.Category;
import com.hobbou.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahma on 28/02/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    List<Category> categories;

    public  CategoryAdapter(List<Category>categories){
        this.categories = categories;
    }
    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        Button btnCategory;
        CategoryViewHolder(View view){
            super(view);
            btnCategory = (Button) view.findViewById(R.id.category_button);
        }
    }
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public int getItemCount() {
        return categories == null ? 0 : categories.size();
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.btnCategory.setText(categories.get(position).getName());
    }
}
