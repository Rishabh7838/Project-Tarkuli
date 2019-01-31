package com.example.rish.projecttarkuli;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
private Button login;
private TextInputEditText emailText,passText;
private String  email,pass;
private String[] users = {"Manager","Supervisor1","Supervisor2","Employee1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        emailText = findViewById(R.id.emailText);
        passText = findViewById(R.id.passText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailText.getText().toString();
                pass = passText.getText().toString();
                if(email.isEmpty()==false &&pass.isEmpty()==false && email.equals(pass) && isValid(email))
                {
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    i.putExtra("Email",email);
                    i.putExtra("Pass",pass);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    emailText.setError("Credential Mismatch");
                    passText.setError("Credential Mismatch");
                }
            }
        });
    }

    private boolean isValid(String email) {
        boolean f = false;
        for(String s: users){
            if(email.equals(s))
                f = true;
        }
        return f;
    }
}
