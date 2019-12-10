package com.koltech.swinka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }

    public void LewelList(View v){
        Intent intent = new Intent(MainActivity.this,LewelList.class);
        startActivity(intent);
    }

    public void jakgrac(View v){
        Intent intent = new Intent(MainActivity.this,jak_grac.class);
        startActivity(intent);
    }

    public void Castom(View v){
        Powiadomienie("Feature available soon.");
        //setContentView(R.layout.leweljeden);
    }
    public void Exit(View v){
        ExitEX();
    }

    public void ExitEX(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.exit_question, null);
        Button tak = (Button) mView.findViewById(R.id.exit_but_tak);
        Button nie = (Button) mView.findViewById(R.id.exit_but_nie);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        tak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                dialog.cancel();
                finish();
            }
        });

        nie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                dialog.cancel();
            }
        });

    }

    @Override
    public void onBackPressed(){
        ExitEX();
    }



    public void Powiadomienie(String wiadomosc){
        Snackbar.make(this.findViewById(android.R.id.content),
                wiadomosc,
                Snackbar.LENGTH_SHORT)
                .setDuration(20000).setAction("Action", null).show();
    }
}
