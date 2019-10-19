package com.example.todosampleapp.main;

import android.util.Log;

import com.example.todosampleapp.base.BasePresenterImpl;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.RepositoryImpl;
import com.example.todosampleapp.model.Item;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter
        extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {
    Repository repository;

    MainPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchItems() {
        Disposable da = this.repository.fetchItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<Item>>) items -> {
                        Log.d("Main", "items -> " + items);
                        view.fetchItemsDone(items);
                });

        bag.add(da);

    }

    @Override
    public void showDetail(int no) {
//        view.showDetail(no);
    }


}
