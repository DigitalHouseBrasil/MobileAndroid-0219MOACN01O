package com.jessica.digitalhouse.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.jessica.digitalhouse.R;
import com.jessica.digitalhouse.home.view.MainActivity;
import com.jessica.digitalhouse.login.viewmodel.LoginViewModel;
import com.jessica.digitalhouse.register.view.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private TextView textViewGotoRegister;
    private ProgressBar progressBar;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        textInputLayoutEmail = findViewById(R.id.textinput_email);
        textInputLayoutPassword = findViewById(R.id.textinput_password);
        textViewGotoRegister = findViewById(R.id.textViewGotoRegister);
        progressBar = findViewById(R.id.progressBar);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        //Vai para tela de registro de usuário
        textViewGotoRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        //Faxz o login
        btnLogin.setOnClickListener(v -> {
            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            if (!email.isEmpty() && !password.isEmpty()) {
                viewModel.login(email, password);
            }
        });

        //Se logou com sucesso vamos direcionar para tela  HOME
        viewModel.getIsLogged().observe(this, isLogged -> {
            if (isLogged) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        // Se deu algum erro mostramos na tela
        viewModel.getLiveDataError().observe(this, throwable -> {
            String error = throwable.getMessage();
            Snackbar.make(btnLogin, error, Snackbar.LENGTH_LONG).show();
        });


        // Mostramos o loading para feeed back ao usuário enquanto carega o login
        viewModel.getIsLoading().observe(this, loading -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
