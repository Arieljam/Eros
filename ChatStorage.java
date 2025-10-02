package com.example.eros;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ChatStorage {

    private static final String PREFS_NAME = "ErosChats";

    // Guardar mensajes
    public static void saveMessages(Context context, String matchName, List<String> messages) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        JSONArray jsonArray = new JSONArray(messages);
        prefs.edit().putString(matchName, jsonArray.toString()).apply();
    }

    // Cargar mensajes
    public static List<String> loadMessages(Context context, String matchName) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String json = prefs.getString(matchName, null);

        List<String> messages = new ArrayList<>();
        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    messages.add(jsonArray.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return messages;
    }
          }
