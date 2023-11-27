package com.example.aplicativopdv.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativopdv.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.edUsuario);
        editTextPassword = findViewById(R.id.edSenha);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("usuario") && password.equals("senha")) {
                    // Login bem-sucedido, redirecione para a próxima atividade
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Exibir mensagem de erro ou tratamento de login inválido
                    Toast.makeText(LoginActivity.this, "Login inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
