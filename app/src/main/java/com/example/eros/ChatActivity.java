package com.example.eros;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerChat;
    private EditText inputMessage;
    private Button btnSend;
    private ChatAdapter chatAdapter;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerChat = findViewById(R.id.recyclerChat);
        inputMessage = findViewById(R.id.inputMessage);
        btnSend = findViewById(R.id.btnSend);

        messages = new ArrayList<>();
        chatAdapter = new ChatAdapter(messages);

        recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        recyclerChat.setAdapter(chatAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputMessage.getText().toString().trim();
                if (!text.isEmpty()) {
                    messages.add(new Message(text, true)); // true = enviado por mí
                    chatAdapter.notifyItemInserted(messages.size() - 1);
                    recyclerChat.scrollToPosition(messages.size() - 1);
                    inputMessage.setText("");

                    // Simulación de respuesta automática
                    messages.add(new Message("Respuesta automática 😅", false));
                    chatAdapter.notifyItemInserted(messages.size() - 1);
                    recyclerChat.scrollToPosition(messages.size() - 1);
                }
            }
        });
    }
                                                  }
