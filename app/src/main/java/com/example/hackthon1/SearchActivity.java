package com.example.hackthon1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    // Sample data for hospitals
    private final List<String> hospitals = new ArrayList<>();
    private List<String> hospitalDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchView searchView = findViewById(R.id.search_view);
        ListView hospitalList = findViewById(R.id.hospital_list);

        // Sample hospital data with different names
        hospitals.add("Sunrise Medical Center - Rating: 4.5 - Address: 101 Sunrise Ave - Distance: 1.2 km");
        hospitals.add("Green Valley Hospital - Rating: 4.0 - Address: 202 Green St - Distance: 2.5 km");
        hospitals.add("Maple Leaf Hospital - Rating: 3.8 - Address: 303 Maple St - Distance: 0.8 km");
        hospitals.add("Riverstone Health Clinic - Rating: 4.2 - Address: 404 River Rd - Distance: 3.0 km");
        hospitals.add("Mountain View Hospital - Rating: 4.7 - Address: 505 Mountain Dr - Distance: 1.5 km");

        // Additional hospital data with different names
        hospitals.add("Cedar Grove Hospital - Rating: 4.3 - Address: 606 Cedar St - Distance: 1.0 km");
        hospitals.add("Ocean Breeze Medical Center - Rating: 4.1 - Address: 707 Ocean Blvd - Distance: 2.0 km");
        hospitals.add("Silver Lake Clinic - Rating: 3.9 - Address: 808 Silver St - Distance: 1.8 km");
        hospitals.add("Pine Hill Hospital - Rating: 4.6 - Address: 909 Pine Hill Rd - Distance: 2.2 km");
        hospitals.add("Valley Forge Health Services - Rating: 4.4 - Address: 1000 Valley Forge Rd - Distance: 1.7 km");
        hospitals.add("Crystal Lake Hospital - Rating: 4.8 - Address: 1111 Crystal Lake Dr - Distance: 3.5 km");
        hospitals.add("Sunset Ridge Medical Center - Rating: 4.2 - Address: 1212 Sunset Ridge Rd - Distance: 2.8 km");

        // Adding Bhimavaram Hospital
        hospitals.add("Bhimavaram Hospital - Rating: 4.5 - Address: 123 Bhimavaram Rd - Distance: 2.0 km");

        // Initialize the adapter with an empty list
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        hospitalList.setAdapter(adapter);

        // Set up the search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Clear the adapter and add filtered results
                adapter.clear();
                if (newText.isEmpty()) {
                    // If the search text is empty, show no results
                    adapter.notifyDataSetChanged();
                } else {
                    for (String hospital : hospitals) {
                        if (hospital.toLowerCase().contains(newText.toLowerCase())) {
                            adapter.add(hospital);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public List<String> getHospitalDetails() {
        return hospitalDetails;
    }

    public void setHospitalDetails(List<String> hospitalDetails) {
        this.hospitalDetails = hospitalDetails;
}
}