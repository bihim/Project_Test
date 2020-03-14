package com.bihim.firestoretest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import static com.bihim.firestoretest.NewsAdapter.DESCRIPTION;
import static com.bihim.firestoretest.NewsAdapter.IMAGE;
import static com.bihim.firestoretest.NewsAdapter.SOURCE;
import static com.bihim.firestoretest.NewsAdapter.TIMEANDDATE;
import static com.bihim.firestoretest.NewsAdapter.TITLE;
import static com.bihim.firestoretest.NewsAdapter.WRITERNAME;

public class NewsClickedActivity extends AppCompatActivity {


    ImageView imageViewNewsImage;

    TextView textViewNewsHeadline;

    TextView textViewNewsDescription;

    TextView textViewNewsTimeAndDate;

    TextView textViewNewsSource;

    TextView textViewNewsWriterName;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_clicked);

        imageViewNewsImage = findViewById(R.id.news_image_clicked);
        textViewNewsHeadline = findViewById(R.id.news_headline_clicked);
        textViewNewsDescription = findViewById(R.id.news_description_clicked);
        textViewNewsTimeAndDate = findViewById(R.id.news_date_clicked);
        textViewNewsSource  = findViewById(R.id.news_source_clicked);
        textViewNewsWriterName = findViewById(R.id.news_writer_name_clicked);

        Intent intent = getIntent();

        String imageResource = intent.getStringExtra(IMAGE);
        String title = intent.getStringExtra(TITLE);
        String description = intent.getStringExtra(DESCRIPTION);
        String timeanddate = intent.getStringExtra(TIMEANDDATE);
        String source = intent.getStringExtra(SOURCE);
        String writerName = intent.getStringExtra(WRITERNAME);


        Glide.with(this).load(imageResource).into(imageViewNewsImage);
        textViewNewsHeadline.setText(title);
        textViewNewsDescription.setText(description);
        textViewNewsTimeAndDate.setText(timeanddate);
        textViewNewsSource.setText(source);
        textViewNewsWriterName.setText(writerName);



    }
}
