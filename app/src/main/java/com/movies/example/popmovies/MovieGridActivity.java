package com.movies.example.popmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MovieGridActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;
    private RecyclerView.Adapter movieAdapter;
    private RecyclerView.LayoutManager movieLayoutManager;
    ImageView[] movieDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        movieRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        movieRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        movieLayoutManager = new GridLayoutManager(this, 2);
        movieRecyclerView.setLayoutManager(movieLayoutManager);

        // specify an adapter (see also next example)
        movieDataset = new ImageView[10];
        for(int i = 0; i < movieDataset.length; i++)
        {
            ImageView mImageView = new ImageView(this);
            Picasso.with(mImageView.getContext()).load("http://i.imgur.com/DvpvklR.png").into(mImageView);
            movieDataset[i] = mImageView;
        }
        movieAdapter = new MovieGridAdapter(movieDataset);
        movieRecyclerView.setAdapter(movieAdapter);
    }
}
