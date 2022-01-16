package com.example.rickmortymvc;


import com.example.rickmortymvc.interfaces.CharacterSevice;


import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterController {
    private static final String TAG = "service";
    private ListaCharacterActivity listaCharacterActivity;


    Retrofit rf = new Retrofit.
            Builder().
            baseUrl(CharacterSevice.BASE_URL).
            addConverterFactory(GsonConverterFactory.create()).
            build();
    CharacterSevice sevice = rf.create(CharacterSevice.class);
    Call<CharacterResponseVO> requestCharacter = sevice.listCharacter();


    public void listarCharacter(Callback<CharacterResponseVO> characterResponse) {
        requestCharacter.enqueue(characterResponse);
    }
}
