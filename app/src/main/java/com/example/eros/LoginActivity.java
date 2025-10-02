package com.example.eros;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eros.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botón de login
        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.inputEmail.getText().toString();
            String password = binding.inputPassword.getText().toString();

            if(email.equals("test@eros.com") && password.equals("1234")) {
                Toast.makeText(this, "Bienvenido a Eros 🔥", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Credenciales incorrectas ❌", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón de ir a registro
        binding.btnGoRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }
                                            }
