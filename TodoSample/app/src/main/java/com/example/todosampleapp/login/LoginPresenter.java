package com.example.todosampleapp.login;

import com.example.todosampleapp.base.BasePresenterImpl;
import com.example.todosampleapp.logic.Repository;
import com.example.todosampleapp.logic.RepositoryImpl;
import com.example.todosampleapp.model.User;

public class LoginPresenter
        extends BasePresenterImpl<LoginContract.View>
        implements LoginContract.Presenter {

    Repository repository;

    public LoginPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void loginProc(User user) {
        this.repository.loginProc(user);
    }
}
