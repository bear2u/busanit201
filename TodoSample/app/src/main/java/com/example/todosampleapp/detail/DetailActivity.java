package com.example.todosampleapp.detail;

import android.os.Bundle;
import android.widget.EditText;

import com.example.todosampleapp.R;
import com.example.todosampleapp.base.BaseActivity;
import com.example.todosampleapp.model.Item;

import butterknife.BindView;

public class DetailActivity
        extends BaseActivity<DetailContract.View, DetailContract.Presenter>
        implements  DetailContract.View {

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etContent)
    EditText etContent;

    @Override
    protected DetailContract.Presenter setPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int no = getIntent().getIntExtra("no", 0);
        mPresenter.fetchItem(no);
    }

    @Override
    public void fetchItemDone(Item item) {
     etTitle.setText(item.getTitle());
     etContent.setText(item.getContent());
    }
}
