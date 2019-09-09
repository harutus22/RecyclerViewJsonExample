package com.example.recyclerviewjsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView creator, likes, views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.detailImageView);
        creator = findViewById(R.id.detailCreatorName);
        likes = findViewById(R.id.detailLikes);
        views = findViewById(R.id.detailViews);

        setData();
    }

    private void setData() {
        ExampleItem exampleItem = getIntent().getParcelableExtra(MainActivity.EXTRA_EXAMPLE_ITEM);
        Picasso.with(this).load(exampleItem.getmImageUrl()).fit().centerInside().into(imageView);
        creator.setText(exampleItem.getmCreator());
        likes.append("Likes: " + exampleItem.getmLikes());
        views.append("Views: " + exampleItem.getmViews());
    }
}
