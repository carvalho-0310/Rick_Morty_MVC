package com.example.rickmortymvc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.rickmortymvc.interfaces.RecyclerViewOnClickListenerAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCharacterActivity extends AppCompatActivity implements RecyclerViewOnClickListenerAdapter {

    private CharacterController characterController = new CharacterController();
    private static final String TAG = "service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView rvCharacter = findViewById(R.id.rv_character);
        ListaCharacterAdapter characterListAdapter = new ListaCharacterAdapter(this);
        characterController.listarCharacter(
                new Callback<CharacterResponseVO>() {
                    @Override
                    public void onResponse(Call<CharacterResponseVO> call, Response<CharacterResponseVO> response) {
                        if (!response.isSuccessful()) {
                            Log.i(TAG, "Erro: " + response.code());
                        } else {

                            CharacterResponseVO characterResponse = response.body();
                            characterListAdapter.listAdapter(characterResponse.getResults());
                        }
                    }

                    @Override
                    public void onFailure(Call<CharacterResponseVO> call, Throwable t) {
                        Log.e(TAG, "Erro: " + t.getMessage());
                    }
                });
        rvCharacter.setAdapter(characterListAdapter);
    }

    @Override
    public void onCliklistener(Character character) {
        Intent intent = new Intent(this, CharacterInfosActivity.class);
        intent.putExtra("c", character);
        startActivity(intent);
    }
}