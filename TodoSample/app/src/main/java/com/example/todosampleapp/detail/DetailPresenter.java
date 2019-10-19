package com.example.todosampleapp.detail;

import android.util.Log;

import com.example.todosampleapp.base.BasePresenterImpl;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.RepositoryImpl;
import com.example.todosampleapp.model.Item;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter
        extends BasePresenterImpl<DetailContract.View>
        implements DetailContract.Presenter {

    Repository repository;

    DetailPresenter() {
        repository = new RepositoryImpl();
        repository.setPresenter(this);
    }

    // Item 가져오기
    @Override
    public void fetchItem(int no) {
        Log.d("Detail", "pos : " + no);
        Disposable da = repository.fetchItem(no)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((Consumer<Item>) item -> view.fetchItemDone(item), new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("Detail", "Error: " + throwable.getMessage());
                    }
                });

        bag.add(da);
    }
}
