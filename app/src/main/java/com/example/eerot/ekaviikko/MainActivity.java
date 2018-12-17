package com.example.eerot.ekaviikko;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText tekstikentta;
    EditText tiedosto;
    Context context = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tekstikentta = findViewById(R.id.tekstikentta);
        tiedosto = findViewById(R.id.tiedosto);

        context = MainActivity.this;

    }


    public void readFile(View v) {

        try {

            String tiednimi = tiedosto.getText().toString().trim();

            InputStream in= context.openFileInput(tiednimi);

            BufferedReader imput = new BufferedReader(new InputStreamReader(in));
            String s= null;

            while ((s= imput.readLine()) != null){
                tekstikentta.setText(s);
            }


        } catch (FileNotFoundException e) {
            Toast.makeText(MainActivity.this, "Virhe", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "Virhe", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }finally {
            Toast.makeText(MainActivity.this, "Toimiii1", Toast.LENGTH_SHORT).show();
            System.out.println("Halooo11");
        }


    }

    public void writeFile(View v) {

        try {

            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput( tiedosto.getText().toString().trim(), Context.MODE_PRIVATE));

            String s= tekstikentta.getText().toString();

            writer.write(s);
            writer.close();

        } catch (FileNotFoundException e) {

            Toast.makeText(MainActivity.this, "Virhe", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "Virhe", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }finally {
            Toast.makeText(MainActivity.this, "Toimiii", Toast.LENGTH_SHORT).show();
            System.out.println("Halooo");
        }




    }
}
