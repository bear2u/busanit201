package com.example.todosampleapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todosampleapp.R;
import com.example.todosampleapp.base.BaseActivity;
import com.example.todosampleapp.model.User;
import com.example.todosampleapp.profile.ProfileActivity;
import com.example.todosampleapp.register.RegisterActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.btnProfile)
    Button btnProfile;

    @BindView(R.id.email)
    EditText etEmail;

    @BindView(R.id.password)
    EditText etPassword;

    @Override
    protected LoginContract.Presenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin.setOnClickListener((view) -> {
            User user = new User();
            user.setEmail(etEmail.getText().toString());
            user.setPwd(etPassword.getText().toString());
            mPresenter.loginProc(user);
        });

        btnRegister.setOnClickListener((view) ->
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class))
        );

        btnProfile.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, ProfileActivity.class)));
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }
}
