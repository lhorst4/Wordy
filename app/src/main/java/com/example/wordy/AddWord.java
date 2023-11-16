package com.example.wordy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class AddWord extends FragmentActivity {
    View.OnClickListener toWordy = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener addWordCL = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String wordToAdd = newWordET.getText().toString();
            wordToAdd = wordToAdd.toLowerCase();
            char[] wordChars = wordToAdd.toCharArray();
            if(wordToAdd.length() != 5){
                addWordTV.setTextColor(Color.rgb(102, 0, 153));
                Toast.makeText(getApplicationContext(), "Word needs to be 5 letters long.", Toast.LENGTH_LONG).show();
                return;
            }
            String validCharString = "abcdefghijklmnopqrstuvwxyz";
            char[] validChars = validCharString.toCharArray();
            for(int i = 0; i < 5; i++){
                if(validCharString.contains(Character.toString(wordChars[i]))){
                    continue;
                }

                addWordTV.setTextColor(Color.rgb(102, 0, 153));
                Toast.makeText(getApplicationContext(), "Invalid character in word.", Toast.LENGTH_LONG).show();
                return;
            }
            addWord(wordToAdd);
        }
    };
    FirebaseDatabase wordDB;
    TextView addWordTV;
    EditText newWordET;
    Button addWordBT;
    Button toWordyBT;
    HashMap<String, Object> wordMap;
    LinkedList<String> wordList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        wordDB = FirebaseDatabase.getInstance();

        wordDB = FirebaseDatabase.getInstance();
        addWordTV = findViewById(R.id.addWordTV);
        newWordET = findViewById(R.id.addWordET);
        addWordBT = findViewById(R.id.addWordBT);
        toWordyBT = findViewById(R.id.toWordyBT);

        toWordyBT.setOnClickListener(toWordy);
        addWordBT.setOnClickListener(addWordCL);
    }

    public void addWord(String newWord){
        newWord = newWord.toLowerCase();
        DatabaseReference dbref = wordDB.getReference("words");
        wordList = new LinkedList<>();
        String finalNewWord = newWord;
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    wordMap = (HashMap<String, Object>) snapshot.getValue();
                    ArrayList<String> keys = new ArrayList<>(wordMap.keySet());
                    for (int i = 0; i < keys.size(); i++) {
                        wordList.add(wordMap.get(keys.get(i)).toString());
                    }
                    if (wordList.contains(finalNewWord)) {
                        Toast.makeText(getApplicationContext(), "This word is already in the database.", Toast.LENGTH_LONG).show();
                    } else {
                        String key = dbref.push().getKey();
                        dbref.child(key).setValue(finalNewWord);
                    }
                }else{
                    String key = dbref.push().getKey();
                    dbref.child(key).setValue(finalNewWord);
                }
                Toast.makeText(getApplicationContext(), finalNewWord + " added to database.", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}