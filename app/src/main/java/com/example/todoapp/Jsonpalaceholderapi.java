package com.example.todoapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.util.List;
public interface Jsonpalaceholderapi {
    String BASE_URL="https://jsonplaceholder.typicode.com/";
    String FEED="posts";
    Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).
            addConverterFactory(GsonConverterFactory.create()).build();
    @GET(FEED)
    Call<List<POST>> getPosts();
}
