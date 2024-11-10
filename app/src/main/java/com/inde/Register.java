package com.inde;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    // Declare UI components
    EditText register_email_edit, register_Phone_edit, register_Date_edit, register_password_edit, register_confirm_password_edit;
    Button register_button,login_button;
    ImageButton registerMaleButton, registerFemaleButton,register_login_with_apple,register_login_with_google;

    // Firebase reference
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // Initialize UI components
        register_email_edit = findViewById(R.id.register_email_edit);
        register_Phone_edit = findViewById(R.id.register_Phone_edit);
        register_Date_edit = findViewById(R.id.register_Date_edit);
        register_password_edit = findViewById(R.id.register_password_edit);
        register_confirm_password_edit = findViewById(R.id.register_confirm_password_edit);
        register_button = findViewById(R.id.register_button);

        firebaseAuth = FirebaseAuth.getInstance();


        //Login button Redirect
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Register button click listener

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = register_email_edit.getText().toString().trim();
                String password = register_password_edit.getText().toString().trim();
                String confirmPassword = register_confirm_password_edit.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    register_email_edit.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    register_password_edit.setError("Password is required");
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword)){
                    register_confirm_password_edit.setError("Confirm Password is required");
                    return;
                }

                if (!password.equals(confirmPassword)){
                    register_confirm_password_edit.setError("Passwords do not match");
                    return;
                }

                if (password.length() < 6){
                    register_password_edit.setError("Password must be at least 6 characters long");
                    return;
                }

//  Register user to Firebase
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this,MainActivity.class));
                    }else {
                        Toast.makeText(Register.this, "Failed to register. Please try again."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            }
        });
}
}

