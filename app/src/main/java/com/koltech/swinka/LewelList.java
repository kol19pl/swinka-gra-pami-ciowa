package com.koltech.swinka;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.lang.reflect.Array;

public class LewelList extends AppCompatActivity {
    Button B1,B2,B3,B4,B5,B6,B7,B8;
    Drawable chek;
    int lewel1 =0;
    int lewel2 =0;
    int lewel3 =0;
    int lewel4 =0;
    int lewel5 =0;
    int lewel6 =0;
    int lewel7 =0;
    int lewel8 =0;
    int lewel9 =0;
    int lewel10 =0;
    int lewel11 =0;
    int lewel12 =0;
    int lewel13 =0;
    int lewel14 =0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_listaleweli);

        Wczytajprefy();

        B1=findViewById(R.id.b1);
        B2=findViewById(R.id.b2);
        B3=findViewById(R.id.b3);
        B4=findViewById(R.id.b4);
        B5=findViewById(R.id.b5);
        B6=findViewById(R.id.b6);
        B7=findViewById(R.id.b7);
        B8=findViewById(R.id.b8);

        spr();

        B1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(LewelList.this,GameLI.class);
                intent.putExtra("Lewel", "1");
                startActivity(intent);
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v)
        {
            if(lewel1==1){
                Intent intent = new Intent(LewelList.this,GameLI.class);
                intent.putExtra("Lewel", "2");
                startActivity(intent);
                }
                else powiadomienie();
           }
            });

        B3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(lewel2==1){
                    Intent intent = new Intent(LewelList.this,GameLI.class);
                    intent.putExtra("Lewel", "3");
                    startActivity(intent);
                }
                else powiadomienie();
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(lewel3==1){
                    Intent intent = new Intent(LewelList.this,GameLI.class);
                    intent.putExtra("Lewel", "4");
                    startActivity(intent);
                }
                else powiadomienie();
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(lewel4==1){
                    Intent intent = new Intent(LewelList.this,GameLI.class);
                    intent.putExtra("Lewel", "5");
                    startActivity(intent);
                }
                else powiadomienie();
            }
        });

        B6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(lewel5==1){
                    Intent intent = new Intent(LewelList.this,GameLI.class);
                    intent.putExtra("Lewel", "6");
                    startActivity(intent);
                }
                else powiadomienie();
            }
        });

        B7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(lewel6==1){
                    Intent intent = new Intent(LewelList.this,GameLI.class);
                    intent.putExtra("Lewel", "7");
                    startActivity(intent);
                }
                else powiadomienie();
            }
        });

        B8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(lewel7==1){
                    Intent intent = new Intent(LewelList.this,GameLI.class);
                    intent.putExtra("Lewel", "8");
                    startActivity(intent);
                }
                else powiadomienie();
            }
        });



    }

    @Override
    public void onResume(){
        super.onResume();

        Wczytajprefy();

        spr();
    }

    void spr(){
        Resources res = getResources();
        chek= ResourcesCompat.getDrawable(res, R.drawable.cheks, null);

        if(lewel1==1){
        B1.setCompoundDrawablesWithIntrinsicBounds(
                null, // Drawable left
                null, // Drawable top
                 chek, // Drawable right
                null // Drawable bottom
        );
        }

        if(lewel2==1){
            B2.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }

        if(lewel3==1){
            B3.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }

        if(lewel4==1){
            B4.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }

        if(lewel5==1){
            B5.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }

        if(lewel6==1){
            B6.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }

        if(lewel7==1){
            B7.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }

        if(lewel8==1){
            B8.setCompoundDrawablesWithIntrinsicBounds(
                    null, // Drawable left
                    null, // Drawable top
                    chek, // Drawable right
                    null // Drawable bottom
            );
        }
    }

    void Wczytajprefy(){
        try {
            SharedPreferences preferences = getSharedPreferences("Swinka", MODE_PRIVATE);
            lewel1 = preferences.getInt("lewel1",0);
            lewel2 = preferences.getInt("lewel2",0);
            lewel3 = preferences.getInt("lewel3",0);
            lewel4 = preferences.getInt("lewel4",0);
            lewel5 = preferences.getInt("lewel5",0);
            lewel6 = preferences.getInt("lewel6",0);
            lewel7 = preferences.getInt("lewel7",0);
            lewel8 = preferences.getInt("lewel8",0);

            lewel9 = preferences.getInt("lewel9",0);
            lewel10 = preferences.getInt("lewel10",0);
            lewel11 = preferences.getInt("lewel11",0);
            lewel12 = preferences.getInt("lewel12",0);
            lewel13 = preferences.getInt("lewel13",0);
            lewel14 = preferences.getInt("lewel14",0);




        }catch (Exception e) { e.printStackTrace();}
    }

    public void ZapiszPref(){
        SharedPreferences.Editor editorpref = getApplicationContext().getSharedPreferences("Swinka", MODE_PRIVATE).edit();
        editorpref.putInt("lewel1",lewel1);
        editorpref.apply();
    }

    void powiadomienie(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(LewelList.this);
        View mView = getLayoutInflater().inflate(R.layout.powiadomienie_lewel, null);
        Button ok = (Button) mView.findViewById(R.id.powok);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                dialog.cancel();
            }
        });
    }

}
