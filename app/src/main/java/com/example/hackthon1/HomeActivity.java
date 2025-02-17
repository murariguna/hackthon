package com.example.hackthon1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
        public void tips(View v) {
            Intent intent = new Intent(HomeActivity.this, TipsActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Redirecting", Toast.LENGTH_SHORT).show();

    }
    public void first(View v) {
        Intent intent = new Intent(HomeActivity.this, FirstaidActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Redirecting", Toast.LENGTH_SHORT).show();

    }
    public void search(View v) {
        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Redirecting", Toast.LENGTH_SHORT).show();

    }
    public void profile(View v) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Redirecting", Toast.LENGTH_SHORT).show();

    }
}