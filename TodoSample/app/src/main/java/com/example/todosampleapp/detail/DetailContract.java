package com.example.todosampleapp.detail;

import com.example.todosampleapp.base.BasePresenter;
import com.example.todosampleapp.base.BaseView;
import com.example.todosampleapp.model.Item;

public class DetailContract {
    public interface View extends BaseView {
        void fetchItemDone(Item item);
    }

    public interface Presenter extends BasePresenter<View> {
        void fetchItem(int no);
    }
}
