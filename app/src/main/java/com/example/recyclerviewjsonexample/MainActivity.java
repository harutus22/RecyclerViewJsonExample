package com.example.recyclerviewjsonexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.OnItemCLickListener {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleItems;
    private RequestQueue mRequestQueue;

    public static final String EXTRA_EXAMPLE_ITEM = "getExampleItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleItems = new ArrayList<>();

        mRequestQueue = VolleySingleton.getInstance(this).getmRequestQueue();

        parseJson();


    }

    private void parseJson(){
        String url = "https://pixabay.com/api/?key=13570992-cce1ba7eac183c68213886eb5=movies&image_type=photo&pretty=true";
        JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likes = hit.getInt("likes");
                                int views = hit.getInt("views");

                                mExampleItems.add(new ExampleItem(imageUrl, creatorName,likes, views));
                            }
                            mExampleAdapter = new ExampleAdapter(getBaseContext(), mExampleItems);
                            mExampleAdapter.setOnItemCLickListener(MainActivity.this);
                            mRecyclerView.setAdapter(mExampleAdapter);
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(jsonObject);
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        ExampleItem clickedItem = mExampleItems.get(position);
        intent.putExtra(EXTRA_EXAMPLE_ITEM, clickedItem);
        startActivity(intent);
    }
}
