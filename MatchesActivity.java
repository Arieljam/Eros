package com.example.eros;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MatchesActivity extends AppCompatActivity {

    private ArrayList<String> matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        ListView listView = findViewById(R.id.listMatches);

        // Obtener matches simulados (se podrían pasar desde MainActivity)
        matches = new ArrayList<>();
        matches.add("Ana");
        matches.add("Lucía");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, matches);
        listView.setAdapter(adapter);

        // Al hacer clic en un match → abrir chat
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String name = matches.get(position);
            Intent intent = new Intent(MatchesActivity.this, ChatActivity.class);
            intent.putExtra("matchName", name);
            startActivity(intent);
        });
    }
                       }
