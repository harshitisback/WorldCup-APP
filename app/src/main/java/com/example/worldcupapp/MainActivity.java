package com.example.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModel> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1 - AdapterView: a listview
        listView = findViewById(R.id.listview);
        // 2- Data Source
        dataModels = new ArrayList<>();
        dataModels.add(new CountryModel("Germany","4",R.drawable.germany));
        dataModels.add(new CountryModel("France","2",R.drawable.france));
        dataModels.add(new CountryModel("brazil","5", R.drawable.brazil));
        dataModels.add(new CountryModel("Spain","1",R.drawable.spain));
        dataModels.add(new CountryModel("England","1", R.drawable.unitedkingdom));
        dataModels.add(new CountryModel("United States","0",R.drawable.unitedstates));
        dataModels.add(new CountryModel("Saudi Arabia","0",R.drawable.saudiarabia));

        // 3- Adapter
        adapter = new CustomAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);

        // 4- Handling the click events on Listview items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Country "+adapter.getItem(i).getCountry_name() +"\n"+
                        "World cup wins: "+adapter.getItem(i).getCup_win_count(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}