package com.example.todosampleapp.logic;

import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface DataSource {
    void setRepository(Repository repository);

    Maybe<Long> registerUser(User user);
    /**
     *
     * @param item
     * @return
     */
    Single<Long> save(Item item);

    /**
     *
     * @return
     */
    Single<List<Item>> fetchItems();

    /**
     *
     * @param no
     * @return
     */
    Single<Item> fetchItem(int no);

    Single<User> loginProc(User user);
}
