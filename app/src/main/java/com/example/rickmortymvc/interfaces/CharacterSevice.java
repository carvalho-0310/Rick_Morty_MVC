package com.example.rickmortymvc.interfaces;

import com.example.rickmortymvc.CharacterResponseVO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterSevice {
    public static final String BASE_URL = "https://rickandmortyapi.com/api/";
    @GET("character")
    Call<CharacterResponseVO> listCharacter();
}
