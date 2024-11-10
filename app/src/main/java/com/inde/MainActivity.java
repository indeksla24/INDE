package com.inde;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.inde.R;
import com.inde.Register;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText emailEditText, passwordEditText;
    private Button loginButton, registerButton;
    private ImageButton googleLoginButton, appleLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.pass);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        googleLoginButton = findViewById(R.id.register_login_with_google);
        appleLoginButton = findViewById(R.id.register_login_with_apple);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null && user.isEmailVerified()) {
                                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, Room_Type_Selection.class));
                                    finish();
                                } else {
                                    showAlert("Email not verified", "Please verify your email first.");
                                }
                            } else {
                                String errorMessage = task.getException().getMessage();
                                Log.e("LoginError", "Error: " + errorMessage);
                                showAlert("Login Failed", errorMessage);
                            }
                        });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
                finish();
            }
        });

        googleLoginButton.setOnClickListener(v -> {
            // Implement Google Login
        });

        appleLoginButton.setOnClickListener(v -> {
            // Implement Apple Login
        });
    }

    private void showAlert(String title, String message) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}