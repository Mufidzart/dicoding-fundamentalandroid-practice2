package com.example.mufidzintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_pindah_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveDataActivity = findViewById(R.id.btn_pindah_with_data);
        btnMoveDataActivity.setOnClickListener(this);

        Button btnMoveObjectActivity = findViewById(R.id.btn_pindah_with_object);
        btnMoveObjectActivity.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_pindah_activity){
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
        } else if(v.getId() == R.id.btn_pindah_with_data){
            Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Mufidz");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 10);
            startActivity(moveWithDataIntent);
        } else if (v.getId() == R.id.btn_pindah_with_object){
            Person person = new Person();
            person.setName("Mufidz");
            person.setAge(22);
            person.setEmail("mufidz@amikompurwokerto.ac.id");
            person.setCity("Purwokerto");
            Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
            startActivity(moveWithObjectIntent);
        } else if (v.getId() == R.id.btn_dial_number){
            String phoneNumber = "085877493514";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(dialPhoneIntent);
        }
    }
}