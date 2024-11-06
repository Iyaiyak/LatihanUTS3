package com.example.latihanuts3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        String name, description, position;
        int image;

        TextView textView_name, textView_position, textView_description;
        ImageView imageView_player;

        name = getIntent().getStringExtra("NAME");
        description = getIntent().getStringExtra("DESCRIPTION");
        position = getIntent().getStringExtra("POSITION");
        image = getIntent().getIntExtra("IMAGE", 0);

        textView_name = findViewById(R.id.textView_Name2);
        textView_description = findViewById(R.id.textView_description2);
        textView_position = findViewById(R.id.textView_Position2);
        imageView_player = findViewById(R.id.imageView_player2);

        textView_name.setText(name);
        textView_description.setText(description);
        textView_position.setText(position);
        imageView_player.setImageResource(image);
    }
}