package com.bihim.firestoretest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsActivity extends AppCompatActivity {

    RecyclerView newsRecyclerView;

    ArrayList<NewsItems> newsItems;
    NewsAdapter newsAdapter;

    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    LinearLayoutManager linearLayoutManager;

    ProgressBar progressBarNews;
    FirebaseFirestore firebaseFirestore;
    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        newsRecyclerView = findViewById(R.id.news_recycler_view);
        progressBarNews = findViewById(R.id.progress_bar_news);

        //newsDummyData();

        newsShow();
    }

    private void newsShow()
    {
        newsRecyclerView.setHasFixedSize(true);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseFirestore = FirebaseFirestore.getInstance();
        newsItems = new ArrayList<>();


        firebaseFirestore.collection("news")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e)
                    {
                        for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots)
                        {
                            String title = documentSnapshot.getString("Title");
                            String imageLink = documentSnapshot.getString("Link");
                            String writerName = "Writer Name: "+documentSnapshot.getString("Name");
                            String source = "Source: "+documentSnapshot.getString("Source");
                            String date = "Date: "+documentSnapshot.getString("Date");
                            String description = documentSnapshot.getString("Description");

                            //Log.d("Title", "onEvent: "+title);
                            newsItems.add(new NewsItems(title, imageLink, writerName, source, date, description));
                            newsAdapter = new NewsAdapter(newsItems, NewsActivity.this);

                            newsRecyclerView.setAdapter(newsAdapter);
                        }
                    }
                });
        //newsItems.add(new NewsItems("asdasd", "asdasd", "asdasd", "asdasd", "asdasdf", "dsdfsdfsdf"));

        //newsRecyclerView.setAdapter(newsAdapter);

        /*newsAdapter = new NewsAdapter(newsItems, this);
        newsRecyclerView.setAdapter(newsAdapter);*/

    }


    /*private void newsDummyData()
    {

        Context context = this;
        linearLayoutManager = new LinearLayoutManager(context);
        newsRecyclerView.setHasFixedSize(true);
        newsRecyclerView.setLayoutManager(linearLayoutManager);

        newsItems = new ArrayList<>();

        firebaseFirestore = FirebaseFirestore.getInstance();

       // documentReference = firebaseFirestore.collection("/news/");

        *//*String title = documentSnapshot.getString("Title");
        String imageLink = documentSnapshot.getString("Link");
        String writerName = documentSnapshot.getString("Name");
        String source = documentSnapshot.getString("Source");
        String date = documentSnapshot.getString("Date");
        String description = documentSnapshot.getString("Description");
        newsItems.add(new NewsItems(title, imageLink, writerName, source, date, description));*//*

        firebaseFirestore.collection("news")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e)
                    {
                        for (QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots)
                        {
                            String title = documentSnapshot.getString("Title");
                            *//*String imageLink = documentSnapshot.getString("Link");
                            String writerName = documentSnapshot.getString("Name");
                            String source = documentSnapshot.getString("Source");
                            String date = documentSnapshot.getString("Date");
                            String description = documentSnapshot.getString("Description");*//*

                            //Log.d("Title", "onEvent: "+title);

                            newsItems.add(new NewsItems("asdasd", "asdasd", "asdasd", "asdasd", "asdasdf", "dsdfsdfsdf"));
                        }
                    }
                });

        newsAdapter = new NewsAdapter(newsItems, this);
        newsRecyclerView.setAdapter(newsAdapter);

        newsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState)
            {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);

                currentItems = linearLayoutManager.getChildCount();
                totalItems = linearLayoutManager.getItemCount();
                scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();

                if (isScrolling && (currentItems+scrollOutItems == totalItems))
                {
                    isScrolling = false;
                    fetchData();
                }
            }
        });

    }

    private void fetchData()
    {
        progressBarNews.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                for(int i = 0; i<5; i++)
                {
                    NewsItems randomItem;
                    Random random = new Random();
                    int randomNewsAdapter = random.nextInt(newsAdapter.getItemCount());
                    randomItem = newsItems.get(randomNewsAdapter);
                    newsItems.add(randomItem); // add news here
                    newsAdapter.notifyDataSetChanged();
                    progressBarNews.setVisibility(View.GONE);
                }

            }
        },2000);
    }*/

}
