package com.inde;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class item_list extends AppCompatActivity {
    public Button bed_button;
    public Button sofa_button;
    public Button chair_button;
    public Button led_tv_button;
    public Button lamp_button;
    public Button testing_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


//        SOFA BUTTON
        sofa_button = findViewById(R.id.sofa_button);
        sofa_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_list.this, sofa_select.class);
                startActivity(intent);
            }
        });

//        LED TV BUTTON
        led_tv_button = findViewById(R.id.led_tv_button);
        led_tv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_list.this, tv_select.class);
                startActivity(intent);
            }
        });

//        CHAIR BUTTON
        chair_button = findViewById(R.id.chair_button);
        chair_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_list.this, chair_select.class);
                startActivity(intent);
            }
        });
//        LAMP SELECT
        lamp_button = findViewById(R.id.lamp_button);
        lamp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_list.this, lamp_select.class);
                startActivity(intent);
            }
        });

//        BED BUTTON
        bed_button = findViewById(R.id.bed_button);
        bed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_list.this, bed_select.class);
                startActivity(intent);
            }
        });

//      testing OPTION

        testing_button = findViewById(R.id.testing_button);
        testing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_list.this, REAL_VIEW_3D_ENVIOURNMENT.class);
                startActivity(intent);
            }
        });
    }
}