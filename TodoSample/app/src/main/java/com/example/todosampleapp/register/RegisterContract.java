package com.example.todosampleapp.register;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.model.User;

public class RegisterContract {
    public interface View extends BaseView {
        void registerSuccess();
        void registerFailed(String errorMsg);
    }

    public interface Presenter extends BasePresenter<View> {
        void registerProc(User user);
    }
}
