package com.inde;

import android.annotation.SuppressLint;
import android.content.Intent;  // Import Intent
import android.os.Bundle;
import android.view.View;  // Import View
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Room_Type_Selection extends AppCompatActivity {

    public Button bedroom_button;
    public Button bathroom_button;
    public Button kitchen_button;
    public Button dining_button;
    public Button item_selection;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room_type_selection);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        BEDROOM BUTTON
        bedroom_button = findViewById(R.id.bedroom_button);
        bedroom_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Room_Type_Selection.this, Bedroom_Selection.class);
                startActivity(intent);
            }
        });

//        BATHROOM BUTTON
        bathroom_button = findViewById(R.id.bathroom_button);
        bathroom_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Room_Type_Selection.this, Bathroom_Selection.class);
                startActivity(intent);
            }
        });
//        KITCHEN BUTTON
        kitchen_button = findViewById(R.id.kitchen_button);
        kitchen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Room_Type_Selection.this, Kitchen_Selection.class);
                startActivity(intent);
            }
        });
//        DINING BUTTON
        dining_button = findViewById(R.id.dining_button);
        dining_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Room_Type_Selection.this, Dining_Selection.class);
                startActivity(intent);
            }
        });

//        ITEM SELECTION BUTTON
        item_selection = findViewById(R.id.item_selection);
        item_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Room_Type_Selection.this, item_list.class);
                startActivity(intent);
            }
        });

    }
}