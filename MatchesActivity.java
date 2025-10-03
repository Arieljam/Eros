package com.example.eros;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MatchesActivity extends AppCompatActivity {

    private ListView listMatches;
    private ArrayAdapter<String> adapter;
    private List<String> matches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        listMatches = findViewById(R.id.listMatches);

        // Lista de ejemplo (después conectamos con Firebase o backend)
        matches = new ArrayList<>();
        matches.add("Ana, 25");
        matches.add("Carlos, 28");
        matches.add("Lucía, 22");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matches);
        listMatches.setAdapter(adapter);
    }
    }
