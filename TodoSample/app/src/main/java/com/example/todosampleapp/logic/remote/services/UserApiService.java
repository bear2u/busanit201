package com.example.todosampleapp.logic.remote.services;

import com.example.todosampleapp.model.User;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

// Retrofit 통신용
public interface UserApiService {
    @POST("users/auth")
    Single<User> login(@Body User user);
}
