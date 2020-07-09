package com.example.shinjitsu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.entities.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.AdapterViewHolder> {


    private ArrayList<News> news;

    public NewsAdapter(ArrayList<News> news){
        this.news = news;
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        public CardView root;
        public TextView cardNewsTitle;
        public TextView cardNewsAuthor;
        public TextView cardNewsMessage;
        public Button details;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.card_news);
            cardNewsTitle = itemView.findViewById(R.id.card_news_title);
            cardNewsAuthor = itemView.findViewById(R.id.card_news_author);
            cardNewsMessage = itemView.findViewById(R.id.card_news_message);
            details = itemView.findViewById(R.id.card_news_details);

        }

    }


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_fragment, parent, false);
        return new AdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

        final Context context = holder.root.getContext();

        final News news = this.news.get(position);

        holder.cardNewsTitle.setText(news.getTitle());
        holder.cardNewsAuthor.setText("Autor: " + news.getAuthor());
        holder.cardNewsMessage.setText(news.getMessage());

        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, news.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }


}
