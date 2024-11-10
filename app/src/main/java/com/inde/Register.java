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

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    // Declare UI components
    private EditText registerEmailEdit, registerPhoneEdit, registerDateEdit, registerPasswordEdit, registerConfirmPasswordEdit;
    private ImageButton registerMaleButton, registerFemaleButton;
    private Button registerButton;
    private TextView registerGender, registerEmailLabel, registerPhoneLabel, registerDobLabel, registerPasswordLabel, registerConfirmPasswordLabel;

    // Firebase reference
    public FirebaseAuth firebaseAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // Initialize UI components
        registerEmailEdit = findViewById(R.id.register_email_edit);
        registerPhoneEdit = findViewById(R.id.register_Phone_edit);
        registerDateEdit = findViewById(R.id.register_Date_edit);
        registerPasswordEdit = findViewById(R.id.register_password_edit);
        registerConfirmPasswordEdit = findViewById(R.id.register_confirm_password_edit);
        registerButton = findViewById(R.id.register_button);

        // Gender selection buttons (Optional logic for selecting gender)
        registerMaleButton = findViewById(R.id.register_male_button);
        registerFemaleButton = findViewById(R.id.register_female_button);

        // Register button click listener
        registerButton.setOnClickListener(v -> {
            // Fetch the entered data
            String email = registerEmailEdit.getText().toString().trim();
            String phone = registerPhoneEdit.getText().toString().trim();
            String dob = registerDateEdit.getText().toString().trim();
            String password = registerPasswordEdit.getText().toString().trim();
            String confirmPassword = registerConfirmPasswordEdit.getText().toString().trim();


//  validate already exist
//
//            if(firebaseAuth.getCurrentUser() != null){
//                startActivity (new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }

            // Validate fields
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(dob) ||
                    TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(Register.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isValidEmail(email)) {
                Toast.makeText(Register.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create User object
            User newUser = new User(email, phone, dob, password);

            // Store the user in Firebase
            String userId = usersRef.push().getKey();  // Generate a unique ID for the user
            if (userId != null) {
                usersRef.child(userId).setValue(newUser)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                                // Optionally, you can redirect to another activity, such as the login page
                            } else {
                                Toast.makeText(Register.this, "Failed to register. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}

class User {
    private String email;
    private String phone;
    private String dob;
    private String password;

    // Constructor
    public User(String email, String phone, String dob, String password) {
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
