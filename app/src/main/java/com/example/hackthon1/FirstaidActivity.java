package com.example.hackthon1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FirstaidActivity extends AppCompatActivity {

    private TextView firstAidInfo;

    private final String[] injuries = {
            "Cuts and Scrapes",
            "Burns",
            "Sprains",
            "Fractures",
            "Insect Bites",
            "Allergic Reactions"
    };

    private final String[] firstAidMethods = {
            "Clean the wound, apply antiseptic, and cover with a bandage.",
            "Cool the burn with running water, cover with a sterile dressing.",
            "Rest, ice, compress, and elevate the injured area.",
            "Immobilize the area and seek medical help.",
            "Clean the bite area, apply ice, and monitor for allergic reactions.",
            "Administer antihistamines and seek medical help if severe."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);

        ListView injuryList = findViewById(R.id.injury_list);
        firstAidInfo = findViewById(R.id.first_aid_info);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, injuries);
        injuryList.setAdapter(adapter);

        injuryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                firstAidInfo.setText(firstAidMethods[position]);
            }
   });
}
}