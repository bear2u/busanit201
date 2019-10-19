package com.example.todosampleapp.register;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.todosampleapp.R;
import com.example.todosampleapp.base.BaseActivity;
import com.example.todosampleapp.model.User;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity<RegisterContract.View, RegisterContract.Presenter>
        implements RegisterContract.View {

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.email)
    EditText etId;

    @BindView(R.id.password)
    EditText etPassword;

    @BindView(R.id.username)
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister.setOnClickListener((view) -> {
            User user = new User();
            user.setEmail(etId.getText().toString());
            user.setPwd(etPassword.getText().toString());
            user.setName(etUsername.getText().toString());
            mPresenter.registerProc(user);
        });
    }

    @Override
    protected RegisterContract.Presenter setPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void registerSuccess() {

    }

    @Override
    public void registerFailed(String errorMsg) {

    }
}
