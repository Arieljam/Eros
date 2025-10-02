package com.example.eros;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.eros.databinding.ActivityChatBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private ChatAdapter adapter;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Lista de mensajes
        messages = new ArrayList<>();
        adapter = new ChatAdapter(messages);

        // Configurar RecyclerView
        binding.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerChat.setAdapter(adapter);

        // Enviar mensaje
        binding.btnSend.setOnClickListener(v -> {
            String text = binding.inputMessage.getText().toString();
            if (!text.isEmpty()) {
                messages.add(new Message("Yo", text));
                adapter.notifyItemInserted(messages.size() - 1);
                binding.inputMessage.setText("");
                binding.recyclerChat.scrollToPosition(messages.size() - 1);
            } else {
                Toast.makeText(this, "Escribe un mensaje", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
