package com.example.mt_first_aplication.App2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import androidx.core.view.WindowInsetsCompat;


import com.example.mt_first_aplication.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity2 extends AppCompatActivity {

    private EditText txtcliente;
    private EditText txtlistado;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.txtlistado=findViewById(R.id.txtlistado);
        this.txtcliente=findViewById(R.id.txtcliente);

    }

    public void Guardar(View vista){

        String texto = txtcliente.getText().toString();
        FileOutputStream file=null;
        try{
                file=openFileOutput("texto.txt",MODE_APPEND);
                file.write(texto.getBytes());
                Log.d("tag1",String.valueOf(getFilesDir()));
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(file!=null){
                try {
                    file.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    public void Leer(View vista) {
        FileInputStream file = null;
        try {
            file = openFileInput("texto.txt");
            InputStreamReader Leerfile = new InputStreamReader(file);
            BufferedReader buferLeer = new BufferedReader(Leerfile);
            String linea;
            StringBuilder parrafo = new StringBuilder();
            while ((linea = buferLeer.readLine()) != null) {
                parrafo.append(linea).append("");
            }
            txtlistado.setText(parrafo);
        } catch (Exception e) {
        }finally{
            if(file!=null){
                try{
                    file.close();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
        }

    }


}
