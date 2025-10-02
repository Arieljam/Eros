package com.example.eros;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eros.databinding.ActivityMainBinding;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ProfileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Crear lista de perfiles de prueba
        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(new UserProfile("Ana", 24, "https://picsum.photos/400/600?1"));
        profiles.add(new UserProfile("Lucas", 28, "https://picsum.photos/400/600?2"));
        profiles.add(new UserProfile("Carla", 22, "https://picsum.photos/400/600?3"));
        profiles.add(new UserProfile("Diego", 30, "https://picsum.photos/400/600?4"));

        // Configurar el CardStackView
        CardStackLayoutManager manager = new CardStackLayoutManager(this, new CardStackListener() {
            @Override
            public void onCardSwiped(Direction direction) {
                if (direction == Direction.Right) {
                    Toast.makeText(MainActivity.this, "💖 Te gustó este perfil", Toast.LENGTH_SHORT).show();
                } else if (direction == Direction.Left) {
                    Toast.makeText(MainActivity.this, "⛔ Rechazado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override public void onCardDragging(Direction direction, float ratio) {}
            @Override public void onCardRewound() {}
            @Override public void onCardCanceled() {}
            @Override public void onCardAppeared(android.view.View view, int position) {}
            @Override public void onCardDisappeared(android.view.View view, int position) {}
        });

        binding.cardStackView.setLayoutManager(manager);

        adapter = new ProfileAdapter(profiles);
        binding.cardStackView.setAdapter(adapter);
    }
}
// Lista de usuarios que me gustan
private List<String> myLikes = new ArrayList<>();

// Lista de matches confirmados
private List<String> matches = new ArrayList<>();

// Cuando hago "like"
private void likeUser(String user) {
    if (!myLikes.contains(user)) {
        myLikes.add(user);

        // Simulación: si el otro también me dio like
        if (user.equals("Ana") || user.equals("Lucía")) { // ejemplo
            matches.add(user);

            // Abrir chat automáticamente
            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
            intent.putExtra("matchName", user);
            startActivity(intent);
        }
    }
                                                 }
