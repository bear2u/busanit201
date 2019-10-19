package com.example.todosampleapp.base;

public interface BasePresenter<T> {
    void setView(T view);
    void removeView();
}
