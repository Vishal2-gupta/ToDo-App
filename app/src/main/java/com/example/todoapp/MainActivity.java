package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.t1);
        Jsonpalaceholderapi jsonpalaceholderapi=Jsonpalaceholderapi.retrofit.create(Jsonpalaceholderapi.class);
        Call<List<POST>> call=jsonpalaceholderapi.getPosts();
        call.enqueue(new Callback<List<POST>>() {
            @Override
            public void onResponse(Call<List<POST>> call, Response<List<POST>> response) {
                if(!response.isSuccessful()){
                    result.setText("Code:"+ response.code());
                    return;
                }
                List<POST> posts=response.body();
                for(POST c:posts){
                    String content="";
                    content += "User ID:" +c.getUserId()+"\n";
                    content += "ID:" + c.getId() + "\n";
                    content += "Title:" +c.getTitle()+"\n";
                    content += "Text:" +c.getText()+"\n\n";
                    result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<POST>> call, Throwable t) {
             result.setText(t.getMessage());
            }
        });
    }
}