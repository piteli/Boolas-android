package com.rush.wender.boolas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookForm extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private static final String TAG = "BookForm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);


        toolbar = (Toolbar) findViewById(R.id.toolbar123);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Please choose building");


        listView = (ListView) findViewById(R.id.listView123);
        ArrayList<Card> arrayList = new ArrayList<>();
        arrayList.add(new Card("drawable://" + R.drawable.fsk7 ,"FSK 7"));
        arrayList.add(new Card("drawable://" + R.drawable.fsk6 ,"FSK 6"));
        arrayList.add(new Card("drawable://" + R.drawable.ff2 ,"FF 2"));
        arrayList.add(new Card("drawable://" + R.drawable.ff4 ,"FF 4"));


        CustomlistAdapter adapter = new CustomlistAdapter(this, R.layout.card_layout, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent;

                switch(i){
                    case 0:
                        intent = new Intent(BookForm.this,dk.class);
                        BookForm.this.startActivity(intent);
                        break;
                    case 1:
                        Log.i("The item clicked was","FSK 6");
                        Toast.makeText(BookForm.this, "Sorry, FSK 6 is not available for the moment. Please choose different building",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Log.i("The item clicked was","FF 2");
                        Toast.makeText(BookForm.this, "Sorry, FF 2 is not available for the moment. Please choose different building",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Log.i("The item clicked was","FF 4");
                        Toast.makeText(BookForm.this, "Sorry, FF 4 is not available for the moment. Please choose different building",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
