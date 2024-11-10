package com.inde;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.inde.R;
import com.inde.Register;

public class MainActivity extends AppCompatActivity {

    EditText username, login_password;
    Button login_button, register_button;

    // Firebase auth
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
        register_button = findViewById(R.id.register_button);

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                // Validate fields
                if (TextUtils.isEmpty(email)) {
                    username.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    username.setError("Email is required");
                    return;
                }

                // Perform Firebase login
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, Room_Type_Selection.class));

                                } else {
                                    Toast.makeText(MainActivity.this, "Failed to login. Please try again."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        // Register button redirect
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
