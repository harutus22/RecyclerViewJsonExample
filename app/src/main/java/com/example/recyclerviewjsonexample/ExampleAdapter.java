package com.example.recyclerviewjsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleViewHolder> {
    private Context mContext;
    private List<ExampleItem> mExampleList;
    private OnItemCLickListener onItemCLickListener;
    private ExampleViewHolder.OnItemClickListener onItemClickListener = new ExampleViewHolder.OnItemClickListener() {
        @Override
        public void itemClicked(int i) {
            if(onItemCLickListener != null){
                onItemCLickListener.onItemClicked(i);
            }
        }
    };

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleItems){
        mContext = context;
        mExampleList = exampleItems;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.exaple_item, parent, false);
        ExampleViewHolder viewHolder = new ExampleViewHolder(view);
        viewHolder.setOnItemClickListener(onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem item = mExampleList.get(position);
        String imageUrl = item.getmImageUrl();
        String name = item.getmCreator();
        int likes = item.getmLikes();
        int views = item.getmViews();

        holder.getmTextViewCreator().setText(name);
        holder.getmTextViewLikes().setText("Likes: " + likes);
        holder.getmTextViewViews().setText("Views: " + views);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.getmImageView());
    }

    @Override
    public int getItemCount() {
        if(mExampleList != null){
            return mExampleList.size();
        }
        return 0;
    }

    public interface OnItemCLickListener{
        void onItemClicked(int position);
    }

    public void setOnItemCLickListener(OnItemCLickListener onItemCLickListener) {
        this.onItemCLickListener = onItemCLickListener;
    }
}
