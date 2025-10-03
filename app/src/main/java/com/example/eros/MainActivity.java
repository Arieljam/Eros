package com.example.eros;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CardStackView cardStackView;
    private ProfileAdapter adapter;
    private List<Profile> profiles;
    private Button btnMatches, btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStackView = findViewById(R.id.cardStackView);
        btnMatches = findViewById(R.id.btnMatches);
        btnChat = findViewById(R.id.btnChat);

        profiles = new ArrayList<>();
        profiles.add(new Profile("Lucía", 22, "https://randomuser.me/api/portraits/women/44.jpg"));
        profiles.add(new Profile("Carlos", 28, "https://randomuser.me/api/portraits/men/34.jpg"));
        profiles.add(new Profile("Sofía", 25, "https://randomuser.me/api/portraits/women/65.jpg"));
        profiles.add(new Profile("Andrés", 30, "https://randomuser.me/api/portraits/men/22.jpg"));

        adapter = new ProfileAdapter(this, profiles);
        CardStackLayoutManager manager = new CardStackLayoutManager(this);
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);

        btnMatches.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MatchesActivity.class));
        });

        btnChat.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ChatActivity.class));
        });
    }
                                      }
                                                 }
