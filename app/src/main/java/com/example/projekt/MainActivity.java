package com.example.projekt;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String[] opisKomp = {
            "Komputer1, 3500zł",
            "Komputer2, 5000zł",
            "Komputer3, 7800zł",
            "Komputer4, 2000zł"
    };

    int[] zdjecieKomp = {
            R.drawable.komputer1,
            R.drawable.komputer2,
            R.drawable.komputer3,
            R.drawable.komputer4
    };

    String[] opisMyszka = {
            "Myszka1, 150zł",
            "Myszka2, 300zł",
            "Myszka3, 400zł"
    };

    int[] zdjecieMyszka = {
            R.drawable.myszka1,
            R.drawable.myszka2,
            R.drawable.myszka3
    };

    String[] opisKlaw = {
            "Klawiatura1, 200zł",
            "Klawiatura2, 300zł",
            "Klawiatura3, 150zł"
    };

    int[] zdjecieKlaw = {
            R.drawable.klawiatura1,
            R.drawable.klawiatura2,
            R.drawable.klawiatura3
    };

    String[] opisMonitor = {
            "Monitor1, 500zł",
            "Monitor2, 800zł",
            "Monitor3, 1000zł"
    };

    int[] zdjecieMonitor = {
            R.drawable.monitor1,
            R.drawable.monitor2,
            R.drawable.monitor3
    };

    int produkt1 = 0;
    int produkt2 = 0;
    int produkt3 = 0;
    int produkt4 = 0;
    int cena_komp;
    int cena_myszka;
    int cena_klaw;
    int cena_monitor;
    TextView cenaWyswietl;
    CheckBox checkkomp;
    CheckBox checkklaw;
    CheckBox checkmyszka;
    CheckBox checkmonitor;
    Button buttonCena;
    TextView numerTelefonu;
    String numer;
    String wiadomosc;
    SmsManager smsManager;
    Button buttonTel;
    String wiad_komp;
    String wiad_myszka;
    String wiad_klaw;
    String wiad_monitor;


    private void sendWithSmsManager() {

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS) ==
                PackageManager.PERMISSION_GRANTED) {

            numer = numerTelefonu.getText().toString();
            if (!numer.equals("") && !wiadomosc.equals("")) {
                smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(
                        numer,
                        null,
                        wiadomosc,
                        null,
                        null

                );
                Toast.makeText(MainActivity.this, "SMS send", Toast.LENGTH_SHORT).show();
                Log.v("TAG", "Sms send");
            } else {
                Toast.makeText(MainActivity.this, "Prosze podac numer telefonu!", Toast.LENGTH_SHORT).show();
                Log.v("TAG", "Prosze podać numer telefonu!");
            }

        } else {
            requestPermissionLauncher.launch(
                    Manifest.permission.SEND_SMS);
        }
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(this, "SMS permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "SMS permission not granted", Toast.LENGTH_SHORT).show();
                }
            });





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_komp);
        cenaWyswietl = findViewById(R.id.cena);
        checkkomp = findViewById(R.id.check_komp);
        checkklaw = findViewById(R.id.check_klawiatura);
        checkmonitor = findViewById(R.id.check_monitor);
        checkmyszka = findViewById(R.id.check_myszka);
        numerTelefonu = findViewById(R.id.teledit);
        wiadomosc = "Dziękujemy za złożenie zamówienia " + wiad_komp + ", " + wiad_klaw + ", " + wiad_myszka + ", " + wiad_monitor + ". Cena to: " + cenaWyswietl;





        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisKomp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),zdjecieKomp,opisKomp);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    switch (position) {
                        case 0:
                            produkt1 = 1;
                            wiad_komp = "Komputer1";
                            break;
                        case 1:
                            produkt1 = 2;
                            wiad_komp = "Komputer2";
                            break;
                        case 2:
                            produkt1 = 3;
                            wiad_komp = "Komputer3";
                            break;
                        case 3:
                            produkt1 = 4;
                            wiad_komp = "Komputer4";
                            break;

                        default:
                            wiad_komp = "";
                    }

            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner_myszka);

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisMyszka);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter1);

        MyAdapter myAdapter1 = new MyAdapter(getApplicationContext(),zdjecieMyszka,opisMyszka);
        spinner.setAdapter(myAdapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        produkt2 = 1;
                        wiad_myszka = "Myszka1";
                        break;
                    case 1:
                        produkt2 = 2;
                        wiad_myszka = "Myszka2";
                        break;
                    case 2:
                        produkt2 = 3;
                        wiad_myszka = "Myszka3";
                        break;

                    default:
                        cena_myszka = 0;
                        wiad_myszka = "";
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner_klawiatura);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisKlaw);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter2);

        MyAdapter myAdapter2 = new MyAdapter(getApplicationContext(),zdjecieKlaw,opisKlaw);
        spinner.setAdapter(myAdapter2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        produkt3 = 1;
                        wiad_klaw = "Klawiatura1";
                        break;
                    case 1:
                        produkt3 = 2;
                        wiad_klaw = "Klawiatura2";
                        break;
                    case 2:
                        produkt3 = 3;
                        wiad_klaw = "Klawiatura3";
                        break;
                    default:
                        wiad_klaw = "";

                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner_monitor);

        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisMonitor);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter3);

        MyAdapter myAdapter3 = new MyAdapter(getApplicationContext(),zdjecieMonitor,opisMonitor);
        spinner.setAdapter(myAdapter3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        produkt4 = 1;
                        wiad_monitor = "Monitor1";
                        break;
                    case 1:
                        produkt4 = 2;
                        wiad_monitor = "Monitor2";
                        break;
                    case 2:
                        produkt4 = 3;
                        wiad_monitor = "Monitor3";
                        break;

                    default:
                        wiad_monitor = "";

                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        buttonCena = findViewById(R.id.btn_cena);
        buttonCena.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //IF KOMPUTER
                if(checkkomp.isChecked()){
                    if(produkt1 == 1){
                        cena_komp = 3500;
                    }
                    else if(produkt1 == 2){
                        cena_komp = 5000;
                    }
                    else if(produkt1 == 3){
                        cena_komp = 7800;
                    }
                    else if(produkt1 == 4){
                        cena_komp = 2000;
                    }
                }else{
                    cena_komp = 0;
                }

                //IF MYSZKA
                if(checkmyszka.isChecked()){
                    if(produkt2 == 1){
                        cena_myszka = 150;
                    }
                    else if(produkt2 == 2){
                        cena_myszka = 300;
                    }
                    else if(produkt2 == 3){
                        cena_myszka = 400;
                    }

                }else{
                    cena_myszka = 0;
                }

                //IF KLAWIATURA
                if(checkklaw.isChecked()){
                    if(produkt3 == 1){
                        cena_klaw = 200;
                    }
                    else if(produkt3 == 2){
                        cena_klaw = 300;
                    }
                    else if(produkt3 == 3){
                        cena_klaw = 150;
                    }

                }else{
                    cena_klaw = 0;
                }

                //IF MONITOR
                if(checkmonitor.isChecked()){
                    if(produkt4 == 1){
                        cena_monitor = 500;
                    }
                    else if(produkt4 == 2){
                        cena_monitor = 800;
                    }
                    else if(produkt4 == 3){
                        cena_monitor = 1000;
                    }

                }else{
                    cena_monitor = 0;
                }
                cenaWyswietl.setText(Integer.toString(cena_komp+cena_myszka+cena_klaw+cena_monitor));

            }
        }
        );

        buttonTel = findViewById(R.id.smsbutton);
        buttonTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendWithSmsManager();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                return true;

            case R.id.autor:
                Intent intent1 = new Intent(MainActivity.this,Autor.class);
                MainActivity.this.startActivity(intent1);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }


    }

}