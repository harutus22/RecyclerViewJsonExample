package com.example.recyclerviewjsonexample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;
    private TextView mTextViewCreator;
    private TextView mTextViewLikes;
    private TextView mTextViewViews;
    private OnItemClickListener onItemClickListener;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(onItemClickListener != null){
                onItemClickListener.itemClicked(getAdapterPosition());
            }
        }
    };

    public ExampleViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.imageView);
        mTextViewCreator = itemView.findViewById(R.id.creatorName);
        mTextViewLikes = itemView.findViewById(R.id.textViewLikes);
        mTextViewViews = itemView.findViewById(R.id.textViewViews);
        itemView.setOnClickListener(onClickListener);
    }

    public ImageView getmImageView() {
        return mImageView;
    }

    public TextView getmTextViewCreator() {
        return mTextViewCreator;
    }

    public TextView getmTextViewLikes() {
        return mTextViewLikes;
    }

    public TextView getmTextViewViews() {
        return mTextViewViews;
    }

    public interface OnItemClickListener{
        void itemClicked(int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
