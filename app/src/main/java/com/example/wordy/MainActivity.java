package com.example.wordy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    View.OnClickListener addWord = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), AddWord.class);
            startActivity(intent);
        }
    };

    View.OnClickListener guess = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            boolean won = false;
            switch(on_guess) {
                case 1:
                    String l1 = g1l1.getText().toString();
                    String l2 = g1l2.getText().toString();
                    String l3 = g1l3.getText().toString();
                    String l4 = g1l4.getText().toString();
                    String l5 = g1l5.getText().toString();

                    String guessWord = l1 + l2 + l3 + l4 + l5;
                    guessWord = guessWord.toLowerCase();
                    if (guessWord.length() < 5) {
                        Toast.makeText(getApplicationContext(), "Fill in all the boxes!", Toast.LENGTH_LONG).show();
                        break;
                    }
                    g1l1.setFocusable(View.NOT_FOCUSABLE);
                    g1l2.setFocusable(View.NOT_FOCUSABLE);
                    g1l3.setFocusable(View.NOT_FOCUSABLE);
                    g1l4.setFocusable(View.NOT_FOCUSABLE);
                    g1l5.setFocusable(View.NOT_FOCUSABLE);
                    if (guessWord.equals(secretWord)) {
                        Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        won = true;
                    }
                    colorBoxes(g1l1, g1l2, g1l3, g1l4, g1l5);
                    if (!won) {
                        word2.setVisibility(View.VISIBLE);
                        on_guess++;
                    }
                    break;
                case 2:
                    l1 = g2l1.getText().toString();
                    l2 = g2l2.getText().toString();
                    l3 = g2l3.getText().toString();
                    l4 = g2l4.getText().toString();
                    l5 = g2l5.getText().toString();
                    guessWord = l1 + l2 + l3 + l4 + l5;
                    guessWord = guessWord.toLowerCase();
                    if (guessWord.length() < 5) {
                        Toast.makeText(getApplicationContext(), "Fill in all the boxes!", Toast.LENGTH_LONG).show();
                        break;
                    }
                    g2l1.setFocusable(View.NOT_FOCUSABLE);
                    g2l2.setFocusable(View.NOT_FOCUSABLE);
                    g2l3.setFocusable(View.NOT_FOCUSABLE);
                    g2l4.setFocusable(View.NOT_FOCUSABLE);
                    g2l5.setFocusable(View.NOT_FOCUSABLE);
                    if (guessWord.equals(secretWord)) {
                        Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        won = true;
                    }
                    colorBoxes(g2l1, g2l2, g2l3, g2l4, g2l5);
                    if (!won) {
                        word3.setVisibility(View.VISIBLE);
                        on_guess++;
                    }
                    break;
                case 3:
                    l1 = g3l1.getText().toString();
                    l2 = g3l2.getText().toString();
                    l3 = g3l3.getText().toString();
                    l4 = g3l4.getText().toString();
                    l5 = g3l5.getText().toString();
                    guessWord = l1 + l2 + l3 + l4 + l5;
                    guessWord = guessWord.toLowerCase();
                    if (guessWord.length() < 5) {
                        Toast.makeText(getApplicationContext(), "Fill in all the boxes!", Toast.LENGTH_LONG).show();
                        break;
                    }
                    g3l1.setFocusable(View.NOT_FOCUSABLE);
                    g3l2.setFocusable(View.NOT_FOCUSABLE);
                    g3l3.setFocusable(View.NOT_FOCUSABLE);
                    g3l4.setFocusable(View.NOT_FOCUSABLE);
                    g3l5.setFocusable(View.NOT_FOCUSABLE);
                    if (guessWord.equals(secretWord)) {
                        Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        won = true;
                    }
                    colorBoxes(g3l1, g3l2, g3l3, g3l4, g3l5);
                    if (!won){
                        word4.setVisibility(View.VISIBLE);
                        on_guess++;
                    }
                    break;
                case 4:
                    l1 = g4l1.getText().toString();
                    l2 = g4l2.getText().toString();
                    l3 = g4l3.getText().toString();
                    l4 = g4l4.getText().toString();
                    l5 = g4l5.getText().toString();
                    guessWord = l1 + l2 + l3 + l4 + l5;
                    guessWord = guessWord.toLowerCase();
                    if(guessWord.length() < 5){
                        Toast.makeText(getApplicationContext(), "Fill in all the boxes!", Toast.LENGTH_LONG).show();
                        break;
                    }
                    g4l1.setFocusable(View.NOT_FOCUSABLE);
                    g4l2.setFocusable(View.NOT_FOCUSABLE);
                    g4l3.setFocusable(View.NOT_FOCUSABLE);
                    g4l4.setFocusable(View.NOT_FOCUSABLE);
                    g4l5.setFocusable(View.NOT_FOCUSABLE);
                    if(guessWord.equals(secretWord)){
                        Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        won = true;
                    }
                    colorBoxes(g4l1, g4l2, g4l3, g4l4, g4l5);
                    if(!won) {
                        word5.setVisibility(View.VISIBLE);
                        on_guess++;
                    }
                    break;
                case 5:
                    l1 = g5l1.getText().toString();
                    l2 = g5l2.getText().toString();
                    l3 = g5l3.getText().toString();
                    l4 = g5l4.getText().toString();
                    l5 = g5l5.getText().toString();
                    guessWord = l1 + l2 + l3 + l4 + l5;
                    guessWord = guessWord.toLowerCase();
                    if(guessWord.length() < 5){
                        Toast.makeText(getApplicationContext(), "Fill in all the boxes!", Toast.LENGTH_LONG).show();
                        break;
                    }
                    g5l1.setFocusable(View.NOT_FOCUSABLE);
                    g5l2.setFocusable(View.NOT_FOCUSABLE);
                    g5l3.setFocusable(View.NOT_FOCUSABLE);
                    g5l4.setFocusable(View.NOT_FOCUSABLE);
                    g5l5.setFocusable(View.NOT_FOCUSABLE);
                    if(guessWord.equals(secretWord)){
                        Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        won = true;
                    }
                    colorBoxes(g5l1, g5l2, g5l3, g5l4, g5l5);
                    if(!won) {
                        word6.setVisibility(View.VISIBLE);
                        on_guess++;
                    }
                    break;
                case 6:
                    l1 = g6l1.getText().toString();
                    l2 = g6l2.getText().toString();
                    l3 = g6l3.getText().toString();
                    l4 = g6l4.getText().toString();
                    l5 = g6l5.getText().toString();
                    guessWord = l1 + l2 + l3 + l4 + l5;
                    guessWord = guessWord.toLowerCase();
                    if(guessWord.length() < 5){
                        Toast.makeText(getApplicationContext(), "Fill in all the boxes!", Toast.LENGTH_LONG).show();
                        break;
                    }
                    g6l1.setFocusable(View.NOT_FOCUSABLE);
                    g6l2.setFocusable(View.NOT_FOCUSABLE);
                    g6l3.setFocusable(View.NOT_FOCUSABLE);
                    g6l4.setFocusable(View.NOT_FOCUSABLE);
                    g6l5.setFocusable(View.NOT_FOCUSABLE);
                    if(guessWord.equals(secretWord)){
                        Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG).show();
                        won = true;
                    }else{
                        Toast.makeText(getApplicationContext(), "Out of attempts, the secret word was "+secretWord, Toast.LENGTH_LONG).show();
                    }
                    colorBoxes(g6l1, g6l2, g6l3, g6l4, g6l5);
                    if(!won) {
                        on_guess++;
                    }
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Out of attempts, the secret word was "+secretWord, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    View.OnClickListener clear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            g1l1.setFocusable(View.FOCUSABLE);
            g1l2.setFocusable(View.FOCUSABLE);
            g1l3.setFocusable(View.FOCUSABLE);
            g1l4.setFocusable(View.FOCUSABLE);
            g1l5.setFocusable(View.FOCUSABLE);

            g1l1.setFocusableInTouchMode(true);
            g1l2.setFocusableInTouchMode(true);
            g1l3.setFocusableInTouchMode(true);
            g1l4.setFocusableInTouchMode(true);
            g1l5.setFocusableInTouchMode(true);

            g2l1.setFocusable(View.FOCUSABLE);
            g2l2.setFocusable(View.FOCUSABLE);
            g2l3.setFocusable(View.FOCUSABLE);
            g2l4.setFocusable(View.FOCUSABLE);
            g2l5.setFocusable(View.FOCUSABLE);

            g2l1.setFocusableInTouchMode(true);
            g2l2.setFocusableInTouchMode(true);
            g2l3.setFocusableInTouchMode(true);
            g2l4.setFocusableInTouchMode(true);
            g2l5.setFocusableInTouchMode(true);

            g3l1.setFocusable(View.FOCUSABLE);
            g3l2.setFocusable(View.FOCUSABLE);
            g3l3.setFocusable(View.FOCUSABLE);
            g3l4.setFocusable(View.FOCUSABLE);
            g3l5.setFocusable(View.FOCUSABLE);

            g3l1.setFocusableInTouchMode(true);
            g3l2.setFocusableInTouchMode(true);
            g3l3.setFocusableInTouchMode(true);
            g3l4.setFocusableInTouchMode(true);
            g3l5.setFocusableInTouchMode(true);

            g4l1.setFocusable(View.FOCUSABLE);
            g4l2.setFocusable(View.FOCUSABLE);
            g4l3.setFocusable(View.FOCUSABLE);
            g4l4.setFocusable(View.FOCUSABLE);
            g4l5.setFocusable(View.FOCUSABLE);

            g4l1.setFocusableInTouchMode(true);
            g4l2.setFocusableInTouchMode(true);
            g4l3.setFocusableInTouchMode(true);
            g4l4.setFocusableInTouchMode(true);
            g4l5.setFocusableInTouchMode(true);

            g5l1.setFocusable(View.FOCUSABLE);
            g5l2.setFocusable(View.FOCUSABLE);
            g5l3.setFocusable(View.FOCUSABLE);
            g5l4.setFocusable(View.FOCUSABLE);
            g5l5.setFocusable(View.FOCUSABLE);

            g5l1.setFocusableInTouchMode(true);
            g5l2.setFocusableInTouchMode(true);
            g5l3.setFocusableInTouchMode(true);
            g5l4.setFocusableInTouchMode(true);
            g5l5.setFocusableInTouchMode(true);

            g6l1.setFocusable(View.FOCUSABLE);
            g6l2.setFocusable(View.FOCUSABLE);
            g6l3.setFocusable(View.FOCUSABLE);
            g6l4.setFocusable(View.FOCUSABLE);
            g6l5.setFocusable(View.FOCUSABLE);

            g6l1.setFocusableInTouchMode(true);
            g6l2.setFocusableInTouchMode(true);
            g6l3.setFocusableInTouchMode(true);
            g6l4.setFocusableInTouchMode(true);
            g6l5.setFocusableInTouchMode(true);

            word1.setVisibility(View.VISIBLE);
            word2.setVisibility(View.INVISIBLE);
            word3.setVisibility(View.INVISIBLE);
            word4.setVisibility(View.INVISIBLE);
            word5.setVisibility(View.INVISIBLE);
            word6.setVisibility(View.INVISIBLE);

            g1l1.setText("");
            g1l2.setText("");
            g1l3.setText("");
            g1l4.setText("");
            g1l5.setText("");
            g2l1.setText("");
            g2l2.setText("");
            g2l3.setText("");
            g2l4.setText("");
            g2l5.setText("");
            g3l1.setText("");
            g3l2.setText("");
            g3l3.setText("");
            g3l4.setText("");
            g3l5.setText("");
            g4l1.setText("");
            g4l2.setText("");
            g4l3.setText("");
            g4l4.setText("");
            g4l5.setText("");
            g5l1.setText("");
            g5l2.setText("");
            g5l3.setText("");
            g5l4.setText("");
            g5l5.setText("");
            g6l1.setText("");
            g6l2.setText("");
            g6l3.setText("");
            g6l4.setText("");
            g6l5.setText("");

            uncolorBoxes(g1l1, g1l2, g1l3, g1l4, g1l5);
            uncolorBoxes(g2l1, g2l2, g2l3, g2l4, g2l5);
            uncolorBoxes(g3l1, g3l2, g3l3, g3l4, g3l5);
            uncolorBoxes(g4l1, g4l2, g4l3, g4l4, g4l5);
            uncolorBoxes(g5l1, g5l2, g5l3, g5l4, g5l5);
            uncolorBoxes(g6l1, g6l2, g6l3, g6l4, g6l5);

            on_guess = 1;
        }
    };

    View.OnClickListener reset = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    FirebaseDatabase wordDB;
    String secretWord;
    LinkedList<String> wordList;
    HashMap<String, Object> wordMap;
    int on_guess = 1;
    Button addBT;
    Button guessBT;
    Button restartBT;
    Button clearBT;
    LinearLayout word1;
    LinearLayout word2;
    LinearLayout word3;

    LinearLayout word4;
    LinearLayout word5;
    LinearLayout word6;
    EditText g1l1;
    EditText g1l2;
    EditText g1l3;
    EditText g1l4;
    EditText g1l5;
    EditText g2l1;
    EditText g2l2;
    EditText g2l3;
    EditText g2l4;
    EditText g2l5;
    EditText g3l1;
    EditText g3l2;
    EditText g3l3;
    EditText g3l4;
    EditText g3l5;
    EditText g4l1;
    EditText g4l2;
    EditText g4l3;
    EditText g4l4;
    EditText g4l5;
    EditText g5l1;
    EditText g5l2;
    EditText g5l3;
    EditText g5l4;
    EditText g5l5;
    EditText g6l1;
    EditText g6l2;
    EditText g6l3;
    EditText g6l4;
    EditText g6l5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDB = FirebaseDatabase.getInstance();

        guessBT = findViewById(R.id.guessBT);
        addBT = findViewById(R.id.addWord);

        addBT.setOnClickListener(addWord);
        guessBT.setOnClickListener(guess);

        word1 = findViewById(R.id.word1);
        word2 = findViewById(R.id.word2);
        word3 = findViewById(R.id.word3);
        word4 = findViewById(R.id.word4);
        word5 = findViewById(R.id.word5);
        word6 = findViewById(R.id.word6);

        word2.setVisibility(View.INVISIBLE);
        word3.setVisibility(View.INVISIBLE);
        word4.setVisibility(View.INVISIBLE);
        word5.setVisibility(View.INVISIBLE);
        word6.setVisibility(View.INVISIBLE);

        g1l1 = findViewById(R.id.g1l1ET);
        g1l2 = findViewById(R.id.g1l2ET);
        g1l3 = findViewById(R.id.g1l3ET);
        g1l4 = findViewById(R.id.g1l4ET);
        g1l5 = findViewById(R.id.g1l5ET);
        g2l1 = findViewById(R.id.g2l1ET);
        g2l2 = findViewById(R.id.g2l2ET);
        g2l3 = findViewById(R.id.g2l3ET);
        g2l4 = findViewById(R.id.g2l4ET);
        g2l5 = findViewById(R.id.g2l5ET);
        g3l1 = findViewById(R.id.g3l1ET);
        g3l2 = findViewById(R.id.g3l2ET);
        g3l3 = findViewById(R.id.g3l3ET);
        g3l4 = findViewById(R.id.g3l4ET);
        g3l5 = findViewById(R.id.g3l5ET);
        g4l1 = findViewById(R.id.g4l1ET);
        g4l2 = findViewById(R.id.g4l2ET);
        g4l3 = findViewById(R.id.g4l3ET);
        g4l4 = findViewById(R.id.g4l4ET);
        g4l5 = findViewById(R.id.g4l5ET);
        g5l1 = findViewById(R.id.g5l1ET);
        g5l2 = findViewById(R.id.g5l2ET);
        g5l3 = findViewById(R.id.g5l3ET);
        g5l4 = findViewById(R.id.g5l4ET);
        g5l5 = findViewById(R.id.g5l5ET);
        g6l1 = findViewById(R.id.g6l1ET);
        g6l2 = findViewById(R.id.g6l2ET);
        g6l3 = findViewById(R.id.g6l3ET);
        g6l4 = findViewById(R.id.g6l4ET);
        g6l5 = findViewById(R.id.g6l5ET);
        restartBT = findViewById(R.id.restartBT);
        clearBT = findViewById(R.id.clearBT);
        restartBT.setOnClickListener(reset);
        clearBT.setOnClickListener(clear);

        setSecretWord();
    }

    public void setSecretWord(){
        DatabaseReference dbref = wordDB.getReference("words");
        wordList = new LinkedList<>();
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    Toast.makeText(getApplicationContext(), "No words in database, please add some! :)", Toast.LENGTH_LONG).show();
                    secretWord = "wordy";
                    Toast.makeText(getApplicationContext(), "Secret word is " + secretWord, Toast.LENGTH_LONG).show();
                    return;
                }
                wordMap = (HashMap<String, Object>) snapshot.getValue();
                ArrayList<String> keys = new ArrayList<>(wordMap.keySet());
                if (keys.size() == 1) {
                    secretWord = wordMap.get(keys.get(0)).toString();
                } else{
                    Random r = new Random();
                    String secretKey = keys.get(r.nextInt(keys.size()));
                    secretWord = wordMap.get(secretKey).toString();
                }
                Toast.makeText(getApplicationContext(), "Secret word is " + secretWord, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void colorBoxes(EditText l1, EditText l2, EditText l3, EditText l4, EditText l5) {

        secretWord = secretWord.toLowerCase();
        String[] wordLetters = new String[5];
        wordLetters[0] = secretWord.substring(0,1);
        wordLetters[1] = secretWord.substring(1,2);
        wordLetters[2] = secretWord.substring(2,3);
        wordLetters[3] = secretWord.substring(3,4);
        wordLetters[4] = secretWord.substring(4);

        if (wordLetters[0].equals(l1.getText().toString().toLowerCase())) {
            l1.setBackgroundColor(Color.GREEN);
            wordLetters[0] = "used";
        }
        if (wordLetters[1].equals(l2.getText().toString().toLowerCase())) {
            l2.setBackgroundColor(Color.GREEN);
            wordLetters[1] = "used";
        }
        if (wordLetters[2].equals(l3.getText().toString().toLowerCase())) {
            l3.setBackgroundColor(Color.GREEN);
            wordLetters[2] = "used";
        }
        if (wordLetters[3].equals(l4.getText().toString().toLowerCase())) {
            l4.setBackgroundColor(Color.GREEN);
            wordLetters[3] = "used";
        }
        if (wordLetters[4].equals(l5.getText().toString().toLowerCase())) {
            l5.setBackgroundColor(Color.GREEN);
            wordLetters[4] = "used";
        }

        if(!wordLetters[0].equals("used") && find(wordLetters, l1.getText().toString().toLowerCase()) != -1){
            l1.setBackgroundColor(Color.YELLOW);
            wordLetters[find(wordLetters, l1.getText().toString().toLowerCase())] = "used";
        }
        if(!wordLetters[1].equals("used") && find(wordLetters, l2.getText().toString().toLowerCase()) != -1){
            l2.setBackgroundColor(Color.YELLOW);
            wordLetters[find(wordLetters, l2.getText().toString().toLowerCase())] = "used";
        }
        if(!wordLetters[2].equals("used") && find(wordLetters, l3.getText().toString().toLowerCase()) != -1){
            l3.setBackgroundColor(Color.YELLOW);
            wordLetters[find(wordLetters, l3.getText().toString().toLowerCase())] = "used";
        }
        if(!wordLetters[3].equals("used") && find(wordLetters, l4.getText().toString().toLowerCase()) != -1){
            l4.setBackgroundColor(Color.YELLOW);
            wordLetters[find(wordLetters, l4.getText().toString().toLowerCase())] = "used";
        }
        if(!wordLetters[4].equals("used") && find(wordLetters, l5.getText().toString().toLowerCase()) != -1){
            l5.setBackgroundColor(Color.YELLOW);
            wordLetters[find(wordLetters, l5.getText().toString().toLowerCase())] = "used";
        }
    }

    public int find(String[] s, String l){
        for(int i = 0; i < s.length; i++){
            if(s[i].equals(l)){
                return i;
            }
        }
        return -1;
    }

    public void uncolorBoxes(EditText l1, EditText l2, EditText l3, EditText l4, EditText l5){
        l1.setBackgroundColor(Color.WHITE);
        l2.setBackgroundColor(Color.WHITE);
        l3.setBackgroundColor(Color.WHITE);
        l4.setBackgroundColor(Color.WHITE);
        l5.setBackgroundColor(Color.WHITE);
    }
}
