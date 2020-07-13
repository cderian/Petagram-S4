package com.cderian.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cderian.petagram.R;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PetFragmentAdapter extends RecyclerView.Adapter<PetFragmentAdapter.PetViewHolder> {

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    Activity activity;

    public PetFragmentAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_pet_fragment, parent, false);

        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgPetCdVw.setImageResource(mascota.getFoto());
        holder.likePhoto.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPetCdVw;
        private TextView likePhoto;
        private ImageButton btnLike;

        public PetViewHolder (@NonNull View itemView) {
            super(itemView);

            imgPetCdVw = itemView.findViewById(R.id.imgPetCdVw);
            likePhoto = itemView.findViewById(R.id.likePhoto);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
