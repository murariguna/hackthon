package com.example.hackthon1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private Button bt;
    private EditText usname;
    private EditText passw;
    private TextView tv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        bt=findViewById(R.id.button);
        usname=findViewById(R.id.editTextText);
        passw=findViewById(R.id.editTextText1);
        tv=findViewById(R.id.textView4);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ussername =usname.getText().toString();
                String pass=passw.getText().toString();
                Database db=new Database(getApplicationContext(), "MEDHUB", null , 1);
                if(ussername.length()==0 || pass.length() == 0){
                    Toast.makeText(LoginActivity.this, "Insufficiant Data", Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        int loginResult = db.login(ussername, pass);
                        if (loginResult == 1) {
                            Toast.makeText(LoginActivity.this, "LOGGING IN.....", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid username and password", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(LoginActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        e.printStackTrace();}
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}