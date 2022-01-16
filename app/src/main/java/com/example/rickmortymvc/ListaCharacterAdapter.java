package com.example.rickmortymvc;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ListaCharacterAdapter extends RecyclerView.Adapter<ListaCharacterAdapter.ViewHolder> {

    private List<Character> list = new ArrayList<>();

    private ListaCharacterActivity listaCharacterActivity;

    public ListaCharacterAdapter(ListaCharacterActivity listaCharacterActivity) {
        this.listaCharacterActivity = listaCharacterActivity;
    }

    public void listAdapter(List<Character> listCharacter) {
        list = listCharacter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListaCharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_line_view, parent, false);
        return new ViewHolder(view, listaCharacterActivity);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaCharacterAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView nameView;
        private final TextView statusView;
        private ListaCharacterActivity listaCharacterActivity;
        private Character character;

        public ViewHolder(@NonNull View itemView, ListaCharacterActivity listaCharacterActivity) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            nameView = itemView.findViewById(R.id.name);
            statusView = itemView.findViewById(R.id.status);


            this.listaCharacterActivity = listaCharacterActivity;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    listaCharacterActivity.onCliklistener(character);
                }
            });

        }

        public void bind(Character character) {
            this.character = character;
            Glide.with(imageView)
                    .load(character.getImage())
                    .into(imageView);
            nameView.setText(character.getName());
            statusView.setText(character.getStatus());
            if (character.getStatus().equals("Dead")) {
                int color = ContextCompat.getColor(statusView.getContext(), R.color.colorRed);
                statusView.setTextColor(color);
            } else if (character.getStatus().equals("Alive")) {
                int color = ContextCompat.getColor(statusView.getContext(), R.color.colorgreem);
                statusView.setTextColor(color);
            }
        }
    }
}
