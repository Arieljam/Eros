package com.example.eros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister, btnExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de la barra superior (Toolbar)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Eros");
        }

        // Referencias a los botones
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnExplore = findViewById(R.id.btnExplore);

        // Mensaje de bienvenida al abrir la app
        Toast.makeText(this, "Bienvenido a Eros ❤️", Toast.LENGTH_SHORT).show();

        // Acciones de botones usando método centralizado
        btnLogin.setOnClickListener(v -> openActivity(LoginActivity.class));
        btnRegister.setOnClickListener(v -> openActivity(RegisterActivity.class));
        btnExplore.setOnClickListener(v -> openActivity(ExploreActivity.class));
    }

    // Método para abrir actividades de forma sencilla
    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
                                      }
                                                 }
