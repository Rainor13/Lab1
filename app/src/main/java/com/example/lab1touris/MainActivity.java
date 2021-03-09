package com.example.lab1touris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Entrada de los datos, R es de resource y debemos asegurarnos tener al menos ids unicos en la misma parte del arbol para cuando lo busquemos.
        // Ya que son usados para encontrar views en concreto, generalmente asigandas en el XML layout.
        TextView textView = (TextView) findViewById(R.id.text_view_id_main);
        textView.setText("");
        final EditText editText = findViewById(R.id.et_main);
        Button shareButton = findViewById(R.id.bt_main_share);
        Button continueButton = findViewById(R.id.bt_main_continue);

        //Para interceptar eventos usamos Listener, que captura los eventos desde la view en concreto
        shareButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String text = editText.getText().toString();
                i.putExtra(Intent.EXTRA_TEXT, text);
                Intent modIntent = Intent.createChooser(i, "Send With..");
                startActivity(i);
                //Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String text = editText.getText().toString();
                if (text.matches("")){
                    text = "No se ha introducido un mensaje";
                }
                Intent i = new Intent(MainActivity.this, ContinueActivity.class);
                i.setType("text/plain");
                i.putExtra("message", text);
                startActivityForResult(i, CODE);
                //startActivity(i);
                //Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent i) {

        super.onActivityResult(requestCode, resultCode, i);
        //preguntar bien lo del request code
        if (requestCode == CODE  && resultCode  == RESULT_OK) {
            TextView textView = (TextView) findViewById(R.id.text_view_id_main);
            String messagetoShow = i.getStringExtra("BtPressed");
            textView.setText(messagetoShow);
        }
    }


}