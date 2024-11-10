package com.inde;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//For animation
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity {
    public Button log_in_button;
    public Button register_button;
    public Button testing_button;
    public ImageButton register_login_with_google;
    public ImageButton register_login_with_apple;
    private Animation clickAnimation;

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

//  Animation Button
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);

        register_login_with_google = findViewById(R.id.register_login_with_google);
        register_login_with_apple = findViewById(R.id.register_login_with_apple);

        register_login_with_google.setOnClickListener(v -> v.startAnimation(clickAnimation));
        register_login_with_apple.setOnClickListener(v -> v.startAnimation(clickAnimation));
            


        log_in_button = findViewById(R.id.log_in_button);
        log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Room_Type_Selection.class);
                startActivity(intent);
            }
        });

        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }
}

