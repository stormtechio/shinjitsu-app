package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.adapters.NewsAdapter;
import com.example.shinjitsu.entities.News;

import java.util.ArrayList;

public class NewsFragment extends Fragment {


    public RecyclerView mNewsRecycler;
    public RecyclerView.Adapter mNewsAdapter;
    public RecyclerView.LayoutManager mNewsLayoutManager;
    public ArrayList<News> news;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

       View view =  inflater.inflate(R.layout.shinjitsu_news_fragment, container, false);

       news = this.getNews();

       mNewsRecycler = view.findViewById(R.id.recycler_view_news);
       mNewsRecycler.setHasFixedSize(true);
       mNewsLayoutManager = new LinearLayoutManager(getContext());
       mNewsAdapter = new NewsAdapter(news);
       mNewsRecycler.setLayoutManager(mNewsLayoutManager);
       mNewsRecycler.setAdapter(mNewsAdapter);


       return view;
   }

   private ArrayList<News> getNews(){
        news = new ArrayList<>();
        News news1 = new News();
        News news2 = new News();
        News news3 = new News();
        News news4 = new News();

        news1.setAuthor("Ayrton Sousa Marinho");
        news1.setTitle("Okinawa no Karate desu");
        news1.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

       news2.setAuthor("Saori Pereira da Costa");
       news2.setTitle("Campeonato Cearense de Karate");
       news2.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

       news3.setAuthor("Jordênio Oliveira");
       news3.setTitle("Campeonato Mundial de Karate");
       news3.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

       news4.setAuthor("Jordênio Oliveira");
       news4.setTitle("Campeonato Mundial de Karate");
       news4.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

       news.add(news1);
       news.add(news2);
       news.add(news3);
       news.add(news4);

       return news;
   }
}
