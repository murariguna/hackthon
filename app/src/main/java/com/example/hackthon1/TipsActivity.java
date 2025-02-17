package com.example.hackthon1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.Random;

public class TipsActivity extends AppCompatActivity {

    private TextView tipsContent;
    private Button randomTipButton;

    // List of tips
    private final List<String> tips = List.of(
            "Always carry a list of your medications and allergies.",
            "Keep your medical records updated and accessible.",
            "Consult your doctor before starting or stopping any medication.",
            "Understand the side effects of your medications.",
            "Follow the prescribed dosage and schedule.",
            "Use a pill organizer to manage your medications.",
            "Never share your medications with others.",
            "Schedule regular check-ups with your healthcare provider.",
            "Ask questions if you don't understand your treatment plan.",
            "Stay informed about your health conditions and treatments."
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        tipsContent = findViewById(R.id.tipsContent);
        randomTipButton = findViewById(R.id.randomTipButton);

        // Set initial tip
        tipsContent.setText(tips.get(0));

        // Set up button click listener to get a random tip
        randomTipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomIndex = random.nextInt(tips.size());
                tipsContent.setText(tips.get(randomIndex));
            }
   });}
}