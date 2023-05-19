package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homepage extends AppCompatActivity {
    TextView textView;
    Button logoutbtn;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        auth = FirebaseAuth.getInstance();
        logoutbtn = findViewById(R.id.button3);
        user = auth.getCurrentUser();

        if(user == null){
            Intent intent = new Intent(homepage.this,loginpage.class);
            startActivity(intent);
        }
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(homepage.this,loginpage.class);
                startActivity(intent);
                Toast.makeText(homepage.this,"ACCOUNT SIGNED OUT", Toast.LENGTH_SHORT).show();
            }
        });
    }
}