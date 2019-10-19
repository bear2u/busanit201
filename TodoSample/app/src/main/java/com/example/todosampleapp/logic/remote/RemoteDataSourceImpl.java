package com.example.todosampleapp.logic.remote;

import android.util.Log;

import com.example.todosampleapp.logic.DataSource;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.remote.services.UserApiService;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.User;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSourceImpl implements DataSource {
    final static private String baseUrl = "https://d710d1e4.ngrok.io/";
    final static private String _TAG = "Remote";

    Repository repository;
    Retrofit retrofit;

    public RemoteDataSourceImpl() {
        initRetrofit();
    }

    public void initRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Long> save(Item item) {
        return null;
    }

    @Override
    public Single<List<Item>> fetchItems() {
        return null;
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return null;
    }

    @Override
    public Maybe<Long> registerUser(User user) {
        //TODO 서버 연동
        return null;
    }

    @Override
    public Single<User> loginProc(User user) {
        //TODO implemention Retrofit
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                UserApiService userApiService = retrofit.create(UserApiService.class);
                Call<JSONObject> call = userApiService.login(user);
                call.enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                        // TODO 성공
                        // status code == 200
                        Log.d(_TAG, response.body() + "");
                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {
                        // TODO 실패
                        t.printStackTrace();
                    }
                });
            }
        });
        thread.start();

        return null;
    }
}
