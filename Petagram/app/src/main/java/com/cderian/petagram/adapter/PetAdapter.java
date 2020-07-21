package com.cderian.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cderian.petagram.R;
import com.cderian.petagram.database.ConstructorMascotas;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    Activity activity;

    public PetAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_pet, parent, false);

        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgPetCdVw.setImageResource(mascota.getFoto());
        holder.txtNombrePetCdVw.setText(mascota.getNombre());
        holder.txtRatePetCdVw.setText(String.valueOf(mascota.getLikes()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructor = new ConstructorMascotas(activity);
                constructor.darLike(mascota);
                holder.txtRatePetCdVw.setText(Integer.toString(constructor.obtenerLikes(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPetCdVw;
        private TextView txtNombrePetCdVw;
        private TextView txtRatePetCdVw;
        private ImageButton btnLike;

        public PetViewHolder (@NonNull View itemView) {
            super(itemView);

            imgPetCdVw = itemView.findViewById(R.id.imgPetCdVw);
            txtNombrePetCdVw = itemView.findViewById(R.id.txtNombrePetCdVw);
            txtRatePetCdVw = itemView.findViewById(R.id.txtRatePetCdVw);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
