package com.example.todosampleapp.login;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.model.User;

public class LoginContract {
    public interface View extends BaseView {
        void loginSuccess();
        void loginFail();
    }

    public interface Presenter extends BasePresenter<View> {
        void loginProc(User user);
    }
}
