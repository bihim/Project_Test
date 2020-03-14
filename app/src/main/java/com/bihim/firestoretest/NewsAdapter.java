package com.bihim.firestoretest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>
{
    ArrayList<NewsItems> newsItems;
    Context context;
    OnItemClickListener onItemClickListener;

    public static final String IMAGE = "newsImage";
    public static final String TITLE = "newsTitle";
    public static final String DESCRIPTION = "newsDescription";
    public static final String TIMEANDDATE = "newsTimeAndDate";
    public static final String SOURCE = "newsSource";
    public static final String WRITERNAME = "newsWriterName";

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }

    public NewsAdapter(ArrayList<NewsItems> newsItems, Context context)
    {
        this.newsItems = newsItems;
        this.context = context;

    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);

        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position)
    {
        final NewsItems selectedItems = newsItems.get(position);

        Glide.with(context).load(selectedItems.getNewsImageLink()).into(holder.newsImage);
        holder.newsTitle.setText(selectedItems.getNewsTitle());
        holder.newsDescription.setText(selectedItems.getNewsDescription());
        holder.newsDate.setText(selectedItems.getNewsDay());
        holder.newsSource.setText(selectedItems.getNewsSource());
        holder.newsWriterName.setText(selectedItems.getNewsWriterName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent clickToSend = new Intent(context, NewsClickedActivity.class);
                clickToSend.putExtra(IMAGE, selectedItems.getNewsImageLink());
                clickToSend.putExtra(TITLE, selectedItems.getNewsTitle());
                clickToSend.putExtra(DESCRIPTION, selectedItems.getNewsDescription());
                clickToSend.putExtra(TIMEANDDATE, selectedItems.getNewsDay());
                clickToSend.putExtra(SOURCE, selectedItems.getNewsSource());
                clickToSend.putExtra(WRITERNAME, selectedItems.getNewsWriterName());
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                context.startActivity(clickToSend);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder
    {

        TextView newsTitle, newsDescription, newsDate, newsWriterName, newsSource;
        ImageView newsImage;

        public NewsHolder(@NonNull View itemView)
        {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
            newsDate = itemView.findViewById(R.id.news_date);
            newsWriterName = itemView.findViewById(R.id.news_writer_name);
            newsSource = itemView.findViewById(R.id.news_writer_source);
            newsImage = itemView.findViewById(R.id.news_image_link);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if(onItemClickListener!=null)
                    {
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }

}
