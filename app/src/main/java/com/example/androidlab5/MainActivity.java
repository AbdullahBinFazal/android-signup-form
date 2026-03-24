package com.example.androidlab5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etPassword, etConfirmPassword;
    private RadioGroup rgGender;
    private Button btnSignUp, btnClear;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        rgGender = findViewById(R.id.rgGender);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnClear = findViewById(R.id.btnClear);
        ivLogo = findViewById(R.id.ivLogo);

        // Load image from assets folder
        loadImageFromAssets();

        // Set click listeners
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSignUp();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });
    }

    private void loadImageFromAssets() {
        try {
            // Open the image from assets folder
            InputStream inputStream = getAssets().open("logo.png");

            // Convert to Bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            // Set to ImageView
            ivLogo.setImageBitmap(bitmap);

            // Close stream
            inputStream.close();

            // Optional: Show success message
            Toast.makeText(this, "Logo loaded successfully!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            // If image not found, show error and use default
            Toast.makeText(this, "Error: logo.png not found in assets folder",
                    Toast.LENGTH_LONG).show();

            // Fallback to default icon
            ivLogo.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    private void validateAndSignUp() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // Validation for Full Name
        if (fullName.isEmpty()) {
            etFullName.setError("Full Name is required");
            etFullName.requestFocus();
            return;
        }

        if (fullName.length() < 3) {
            etFullName.setError("Name must be at least 3 characters");
            etFullName.requestFocus();
            return;
        }

        // Validation for Email
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email address");
            etEmail.requestFocus();
            return;
        }

        // Validation for Password
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            etPassword.setError("Password must contain:\n- At least 8 characters\n- One uppercase letter\n- One lowercase letter\n- One digit");
            etPassword.requestFocus();
            return;
        }

        // Validation for Confirm Password
        if (confirmPassword.isEmpty()) {
            etConfirmPassword.setError("Please confirm your password");
            etConfirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return;
        }

        // Validation for Gender
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender.getText().toString();

        // All validations passed
        String successMessage = "Sign Up Successful!\n\n" +
                "Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "Gender: " + gender;

        Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show();
    }

    private void clearForm() {
        etFullName.setText("");
        etEmail.setText("");
        etPassword.setText("");
        etConfirmPassword.setText("");
        rgGender.clearCheck();

        etFullName.setError(null);
        etEmail.setError(null);
        etPassword.setError(null);
        etConfirmPassword.setError(null);

        etFullName.requestFocus();

        Toast.makeText(this, "Form Cleared", Toast.LENGTH_SHORT).show();
    }
}