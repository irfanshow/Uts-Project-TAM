package com.example.foreignerchats.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foreignerchats.MainActivity;
import com.example.foreignerchats.R;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailField;
    EditText passwordField;
    Button loginBtn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        emailField    = findViewById(R.id.email_login);
        passwordField = findViewById(R.id.password_login);
        loginBtn      = findViewById(R.id.login_btn);

        auth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(v -> {
            String email    = emailField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(LoginActivity.this, R.string.error_all_fields_required, Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(LoginActivity.this, R.string.error_password_length, Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, R.string.error_auth_failed, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}