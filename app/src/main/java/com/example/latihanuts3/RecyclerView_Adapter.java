package com.example.latihanuts3;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder> {
    private final RecylcerView_interface recycle;
    Context context;
    ArrayList<PlayerModel> playerModels = new ArrayList<>();

    public RecyclerView_Adapter(Context context, ArrayList<PlayerModel> playerModels, RecylcerView_interface recycle) {
        this.context = context;
        this.playerModels = playerModels;
        this.recycle = recycle;
    }

    @NonNull
    @Override
    public RecyclerView_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new RecyclerView_Adapter.MyViewHolder(view, recycle);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_Adapter.MyViewHolder holder, int position) {
        holder.image.setImageResource(playerModels.get(position).getImage());
        holder.name.setText(playerModels.get(position).getName());
        holder.position.setText(playerModels.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return playerModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, position;
        ImageView image;

        public MyViewHolder(@NonNull View itemView, RecylcerView_interface recycle) {
            super(itemView);

            name = itemView.findViewById(R.id.textView_name1);
            position = itemView.findViewById(R.id.textView_position1);
            image = itemView.findViewById(R.id.imageView_player1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recycle != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recycle.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
