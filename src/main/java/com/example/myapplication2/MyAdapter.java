package com.example.myapplication2;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<It> ItList;

    public MyAdapter(List<It> ItList) {
        this.ItList = ItList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        It it = ItList.get(position);
        holder.t.setText(it.getS());

    }



    @Override
    public int getItemCount() {
        return ItList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t;

        public MyViewHolder(android.view.View itemView) {
            super(itemView);
            this.t = itemView.findViewById(R.id.tv);
        }
    }
}
