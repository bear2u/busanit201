package com.example.todosampleapp.logic.remote;

import com.example.todosampleapp.logic.DataSource;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.remote.services.UserApiService;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.User;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSourceImpl implements DataSource {
    final static private String _TAG = "Remote";

    Repository repository;

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
    public Maybe<User> loginProc(User user) {
        //TODO implemention Retrofit
        UserApiService userApiService = NetRetrofit.getInstance().getRetrofit()
                .create(UserApiService.class);
        return userApiService.login(user);
    }
}
