package com.rush.wender.boolas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class BookForm extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton fsk7;
    private ImageButton fsk6;
    private ImageButton ff2;
    private ImageButton ff4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);

        fsk7 = (ImageButton) findViewById(R.id.fsk7);
        fsk6 = (ImageButton) findViewById(R.id.fsk6);
        ff2 = (ImageButton) findViewById(R.id.ff2);
        ff4 = (ImageButton) findViewById(R.id.ff4);

        fsk6.setEnabled(false);
        ff2.setEnabled(false);
        ff4.setEnabled(false);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Choose Hall");

        fsk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookForm.this, dk.class);
                BookForm.this.startActivity(intent);
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
