package com.example.todosampleapp.logic;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.User;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

public interface Repository<T> {
    void setPresenter(BasePresenter<T> presenter);
    Single<Long> save(Item item);
    void saveDone();

    //Fetch
    Single<List<Item>> fetchItems();
    void fetchItemsDone(List<Item> items);

    Single<Item> fetchItem(int no);

    Maybe<User> loginProc(User user);
}
