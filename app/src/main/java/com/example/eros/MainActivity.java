package com.eros.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CardStackView cardStackView;
    private CardStackLayoutManager manager;
    private ProfileAdapter adapter;

    private Button btnMatches;
    private Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias UI
        cardStackView = findViewById(R.id.cardStackView);
        btnMatches = findViewById(R.id.btnMatches);
        btnSettings = findViewById(R.id.btnSettings);

        // Configuración CardStack
        manager = new CardStackLayoutManager(this, new CardStackListener() {
            @Override
            public void onCardSwiped(Direction direction) {
                if (direction == Direction.Right) {
                    Toast.makeText(MainActivity.this, "💘 ¡Match!", Toast.LENGTH_SHORT).show();
                } else if (direction == Direction.Left) {
                    Toast.makeText(MainActivity.this, "❌ No te interesa", Toast.LENGTH_SHORT).show();
                }
            }
            // Otros métodos vacíos
            @Override public void onCardDragging(Direction direction, float ratio) {}
            @Override public void onCardRewound() {}
            @Override public void onCardCanceled() {}
            @Override public void onCardAppeared(android.view.View view, int position) {}
            @Override public void onCardDisappeared(android.view.View view, int position) {}
        });

        adapter = new ProfileAdapter(getSampleProfiles());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);

        // Botón Matches
        btnMatches.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Abrir lista de matches", Toast.LENGTH_SHORT).show()
        );

        // Botón Configuración
        btnSettings.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Abrir configuración", Toast.LENGTH_SHORT).show()
        );
    }

    // Datos de prueba (se cambiarán después por Firebase)
    private List<Profile> getSampleProfiles() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Ana", 24, "https://randomuser.me/api/portraits/women/1.jpg"));
        profiles.add(new Profile("Lucía", 27, "https://randomuser.me/api/portraits/women/2.jpg"));
        profiles.add(new Profile("María", 22, "https://randomuser.me/api/portraits/women/3.jpg"));
        profiles.add(new Profile("Sofía", 29, "https://randomuser.me/api/portraits/women/4.jpg"));
        return profiles;
    }
}
                                                 }
