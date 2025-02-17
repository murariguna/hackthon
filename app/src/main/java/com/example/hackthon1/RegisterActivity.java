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

public class RegisterActivity extends AppCompatActivity {

    private TextView txv;
    private Button bt1;
    private EditText username, password, password2, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        txv = findViewById(R.id.textView);
        bt1 = findViewById(R.id.button1);
        username = findViewById(R.id.editTextText3);
        email = findViewById(R.id.editTextText4);
        password = findViewById(R.id.editTextText5);
        password2 = findViewById(R.id.editTextText6);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = username.getText().toString();
                String b = email.getText().toString();
                String c = password.getText().toString();
                String d = password2.getText().toString();
                Database db=new Database(getApplicationContext(), "MEDHUB", null , 1);


                if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Insufficient Credentials", Toast.LENGTH_SHORT).show();
                } else if (!c.equals(d)) {
                    Toast.makeText(RegisterActivity.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                } else {
                    db.register(a,b,c);
                    startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
                    Toast.makeText(RegisterActivity.this, "log in using your credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });


        txv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}