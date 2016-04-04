package com.werockstar.loginwithespresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.edtUsername) EditText edtUsername;

    @Bind(R.id.edtPassword) EditText edtPassword;

    @Bind(R.id.btnLogin) Button btnLogin;

    @Bind(R.id.tvResult) TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    void Login() {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.equals("WeRockStar") && password.equals("root")) {
            tvResult.setText("Successful");
        }else {
            tvResult.setText("Unsuccessful");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
