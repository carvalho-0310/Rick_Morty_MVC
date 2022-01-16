package com.example.rickmortymvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class CharacterInfosActivity extends AppCompatActivity {
    private  ImageView imageView;
    private TextView nameView;
    private  TextView statusView;
    private  TextView speciesView;
    private  TextView genderView;
    private  TextView originView;
    private  TextView localizacaoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_infos);
        Character character = (Character) getIntent().getSerializableExtra("c");
        Toast.makeText(this, character.getName(), Toast.LENGTH_LONG).show();
        imageView = findViewById(R.id.image_info);
        nameView = findViewById(R.id.name_info);
        statusView = findViewById(R.id.status_info);
        speciesView = findViewById(R.id.species_info);
        genderView = findViewById(R.id.gender_info);
        originView = findViewById(R.id.origin_info);
        localizacaoView = findViewById(R.id.localizacao_info);

        Glide.with(imageView)
                .load(character.getImage())
                .into(imageView);
        nameView.setText(character.getName());
        statusView.setText(character.getStatus());
        speciesView.setText(character.getSpecies());
        genderView.setText(character.getGender());
        originView.setText(character.getOrigin().getName());
       localizacaoView.setText(character.getLocation().getName());


    }
}
