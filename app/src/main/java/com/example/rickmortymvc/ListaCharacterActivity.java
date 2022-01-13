package com.example.rickmortymvc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


public class ListaCharacterActivity extends AppCompatActivity {

    private CharacterController characterController =new CharacterController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView rvCharacter = findViewById(R.id.rv_character);

        ListaCharacterAdapter characterListAdapter = new ListaCharacterAdapter();
        characterListAdapter.listAdapter(characterController.listarCharacter());
        rvCharacter.setAdapter(characterListAdapter);

    }

}