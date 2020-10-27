package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText itemEditText;
    private ListView listView;
    private ArrayList<String> dataSouce;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemEditText = findViewById(R.id.editTextAddItem);

        // Data source
        dataSouce = new ArrayList<>();
        dataSouce.add("Item 1");
        dataSouce.add("Item 2");
        dataSouce.add("Item 3");

        // Adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataSouce
        );

        // Connect adapter -> ListView
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // TODO: Uppgift - Hantera onClick. Logga vilket item man tryckte på
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = dataSouce.get(position);
                Log.d("Will", item);
//                Log.d("Will", item);

            }
        });

    }

    // TODO: Uppgift - Kunna lägga till nya items
    public void addBtnPressed(View view) {
        // Get text
        String newItem = itemEditText.getText().toString();
        adapter.add(newItem); // Alt. 1
        // dataSouce.add(newItem); // Alt. 2
        // adapter.notifyDataSetChanged();

        // Clear editText
        itemEditText.setText("");
    }
}