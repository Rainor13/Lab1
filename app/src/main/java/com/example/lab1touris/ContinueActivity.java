package com.example.lab1touris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContinueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        TextView textView = (TextView) findViewById(R.id.text_view_id);
        Button Button1 = findViewById(R.id.bt_1);
        Button Button2 = findViewById(R.id.bt_2);
        Button Button3 = findViewById(R.id.bt_3);

        Intent i = getIntent();
        String messagetoShow= i.getStringExtra("message");
        textView.setText(messagetoShow);

//        if (messagetoShow.matches("")) {
//            //Toast.makeText(this, "No se ha introducido un mensaje", Toast.LENGTH_SHORT).show();
//            textView.setText("No se ha introducido un mensaje");
//            return;
//        }else {
//
//        }

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContinueActivity.this, MainActivity.class);
                i.setType("text/plain");
                //String text = getResources().getString(R.string.Button2);
                String text = "Boton1";
                i.putExtra("BtPressed", text);
                setResult(RESULT_OK, i);
                ContinueActivity.this.finish();
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContinueActivity.this, MainActivity.class);
                i.setType("text/plain");
                //String text = getResources().getString(R.string.Button2);
                String text = "Boton2";
                i.putExtra("BtPressed", text);
                setResult(RESULT_OK, i);
                ContinueActivity.this.finish();
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContinueActivity.this, MainActivity.class);
                i.setType("text/plain");
                //String text = getResources().getString(R.string.Button2);
                String text = "Boton3";
                i.putExtra("BtPressed", text);
                setResult(RESULT_OK, i);
                ContinueActivity.this.finish();
                //finish();
            }
        });
    }
}