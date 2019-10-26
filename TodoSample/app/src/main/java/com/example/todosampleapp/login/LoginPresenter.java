package com.example.todosampleapp.login;

import android.util.Log;

import com.example.todosampleapp.base.BasePresenterImpl;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.RepositoryImpl;
import com.example.todosampleapp.model.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter
        extends BasePresenterImpl<LoginContract.View>
        implements LoginContract.Presenter {

    Repository repository;
    private static final String _TAG = "LoginPresenter";

    public LoginPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void loginProc(User user) {
        Disposable disposable = this.repository.loginProc(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<User>) result -> {
                    Log.d(_TAG, "onSuccess user = " + result.toString());
                    view.loginSuccess();
                },
                throwable -> {
                },
                () -> {
                    Log.d(_TAG, "onComplete user");
                    view.loginFail();
                });

        bag.add(disposable);
    }
}
