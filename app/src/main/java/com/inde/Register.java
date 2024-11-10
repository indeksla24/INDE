package com.inde;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//For animation
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Register extends AppCompatActivity {
    public Button register_login_button;
    public Button register_button;
    public ImageButton register_login_with_google;
    public ImageButton register_login_with_apple;
    public ImageButton register_male_button;
    public ImageButton register_female_button;
    public ImageView tick_male;
    public ImageView tick_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        male female button animation
        ImageButton register_male_button = findViewById(R.id.register_male_button);
        ImageButton register_female_button = findViewById(R.id.register_female_button);
        ImageButton register_login_with_google = findViewById(R.id.register_login_with_google);
        ImageButton register_login_with_apple = findViewById(R.id.register_login_with_apple);

        tick_male = findViewById(R.id.tick_male);
        tick_female = findViewById(R.id.tick_female);

        Animation clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);

        register_male_button.setOnClickListener(v -> v.startAnimation(clickAnimation));
        register_female_button.setOnClickListener(v -> v.startAnimation(clickAnimation));
        register_login_with_google.setOnClickListener(v -> v.startAnimation(clickAnimation));
        register_login_with_apple.setOnClickListener(v -> v.startAnimation(clickAnimation));


// Male tick mark
        register_male_button.setOnClickListener(v -> {
            v.startAnimation(clickAnimation);
            tick_male.setVisibility(View.VISIBLE);
            tick_female.setVisibility(View.GONE);  // Hide the other tick if it's shown
        });

// Female tick mark
        register_female_button.setOnClickListener(v -> {
            v.startAnimation(clickAnimation);
            tick_female.setVisibility(View.VISIBLE);
            tick_male.setVisibility(View.GONE);  // Hide the other tick if it's shown
        });


        register_login_button = findViewById(R.id.register_login_button);
        register_login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}