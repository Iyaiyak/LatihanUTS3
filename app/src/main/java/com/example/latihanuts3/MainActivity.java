package com.example.latihanuts3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecylcerView_interface{
    ArrayList<PlayerModel> playerModels = new ArrayList<>();

    int[] images = {R.drawable.cole_palmer, R.drawable.enzo_fernandez, R.drawable.joao_felix, R.drawable.mikhailo_mudryk,
            R.drawable.nicholas_jackson,R.drawable.noni_madueke,R.drawable.pedro_neto,R.drawable.reece_james,R.drawable.filip_jorgensen,
            R.drawable.marc_cucurella,R.drawable.moises_caicedo,R.drawable.tosin_adarabioyo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpModels();
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(this, playerModels, this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    void setUpModels(){
        String[] name = getResources().getStringArray(R.array.player_name);
        String[] position = getResources().getStringArray(R.array.player_position);
        String[] description = getResources().getStringArray(R.array.player_desc);

        for (int i = 0 ; i < name.length; i++){
            playerModels.add(new PlayerModel(name[i], position[i], description[i], images[i]));
        }
    }


    @Override
    public void onItemClick(int pos) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("NAME", playerModels.get(pos).getName());
        intent.putExtra("DESCRIPTION", playerModels.get(pos).getDescription());
        intent.putExtra("POSITION", playerModels.get(pos).getPosition());
        intent.putExtra("IMAGE", playerModels.get(pos).getImage());

        startActivity(intent);

    }
}