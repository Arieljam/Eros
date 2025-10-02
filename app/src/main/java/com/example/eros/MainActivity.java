package com.example.eros;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.eros.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Vinculamos la vista con ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Texto de bienvenida
        binding.textViewHello.setText("🔥 Bienvenido a Eros 🔥");
    }
                       }
