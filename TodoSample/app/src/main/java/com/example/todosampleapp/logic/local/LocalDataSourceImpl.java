package com.example.todosampleapp.logic.local;

import com.example.todosampleapp.logic.DataSource;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.model.Item;
import com.example.todosampleapp.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class LocalDataSourceImpl implements DataSource {
    Repository repository;
    AppDatabase appDatabase;

    public LocalDataSourceImpl() {
        try {
            appDatabase = AppDatabaseProvider.getINSTANCE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Long> save(final Item item) {
        //TODO SAVE
        return getItemDao().saveItem(item);
    }

    // Fetch Items
    @Override
    public Single<List<Item>> fetchItems() {
        return getItemDao().fetchItems();
    }

    @Override
    public Single<Item> fetchItem(int no) {
        // Item 내 title -> title + "_";
        return getItemDao().fetchItem(no)
                .firstOrError();

    }

    private ItemDao getItemDao() {
        return appDatabase.getItemDao();
    }

    @Override
    public Maybe<Long> registerUser(User user) {
        return null;
    }

    @Override
    public Single<User> loginProc(User user) {
        return null;
    }
}
