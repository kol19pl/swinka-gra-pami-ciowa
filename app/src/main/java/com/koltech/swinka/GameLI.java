package com.koltech.swinka;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class GameLI extends AppCompatActivity {

    ///kart storedz
    ImageButton K1,K2,K3,K4,K5,K6,K7,K8,K9,K10,K11,K12,K13,K14,K15,K16,K17,K20;
    //  Resources res;
    Drawable zakryta;
    Drawable czerwona;
    Drawable niebieska;
    Drawable zielona;
    Drawable zulta;
    Drawable pomaranczowa;
    Drawable ruzowa;

    TextView GurnabelkaPunkty;
    //int[] kolory6 = new int[6];
    List<Integer> Listakolorow ;


    SharedPreferences.Editor editorpref;

     //Kolory kart
     Integer Kk1,Kk2,Kk3,Kk4,Kk5,Kk6,Kk7,Kk8,Kk9,Kk10,Kk11,Kk12,Kk13,Kk14,Kk15,Kk16,Kk17,Kk18,Kk19,Kk20;
     //1 czerwona
     //2 niebieska
     //3 zielona
     //4 zulta

    int kartaWybrana=0;

    //int kolorKartyWybranej=8;

    int PunktyZaliczeniaLewelu=0;

    int PunktyDoZaliczeniaLewelu=3;



    int lewel=0;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
        String value = extras.getString("Lewel");
        lewel = Integer.parseInt(value);
        }

        setup();

        if(lewel == 1){StartL1();}
        if(lewel == 2){StartL2();}
        if(lewel == 3){StartL3();}
        if(lewel>3&&lewel<9){PunktyDoZaliczeniaLewelu=5; StartL4UP();}
        if(lewel>8&&lewel<14){PunktyDoZaliczeniaLewelu=5; StartL9UP();}
        if(lewel>13){PunktyDoZaliczeniaLewelu=5; StartL14UP();}


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    void StartL1(){
        setContentView(R.layout.leweljeden);
        GurnabelkaPunkty = (TextView) findViewById(R.id.BelkaGpunkty);
        uruchomlewel(lewel);
    }
    void StartL2(){
        setContentView(R.layout.leweljeden);
        GurnabelkaPunkty = (TextView) findViewById(R.id.BelkaGpunkty);
        uruchomlewel(lewel);
    }
    void StartL3(){
        setContentView(R.layout.leweljeden);
        GurnabelkaPunkty = (TextView) findViewById(R.id.BelkaGpunkty);

        uruchomlewel(lewel);

    }
    void StartL4UP(){
        setContentView(R.layout.lewelcztery);
        GurnabelkaPunkty = (TextView) findViewById(R.id.BelkaGpunkty);
        uruchomlewel(lewel);
    }
    void StartL9UP(){
        setContentView(R.layout.leweldziewienc);
        GurnabelkaPunkty = (TextView) findViewById(R.id.BelkaGpunkty);
        uruchomlewel(lewel);
    }

    void StartL14UP(){
        setContentView(R.layout.lewelczternasty);
        GurnabelkaPunkty = (TextView) findViewById(R.id.BelkaGpunkty);
        uruchomlewel(lewel);
    }


    void setup(){

        editorpref = getApplicationContext().getSharedPreferences("Swinka", MODE_PRIVATE).edit();

        Resources res = getResources();
        zakryta = ResourcesCompat.getDrawable(res, R.drawable.zakryta, null);
        czerwona = ResourcesCompat.getDrawable(res, R.drawable.czerwona, null);
        niebieska = ResourcesCompat.getDrawable(res, R.drawable.niebieska, null);
        zielona = ResourcesCompat.getDrawable(res, R.drawable.zielona, null);
        zulta = ResourcesCompat.getDrawable(res, R.drawable.zulta, null);
        pomaranczowa = ResourcesCompat.getDrawable(res, R.drawable.pomaranczowa, null);
        ruzowa = ResourcesCompat.getDrawable(res, R.drawable.ruzowa, null);

}
    void zakryjkarty(){
        K1.setBackground(zakryta);
        K2.setBackground(zakryta);
        K3.setBackground(zakryta);
        K4.setBackground(zakryta);
        K5.setBackground(zakryta);
        K6.setBackground(zakryta);
        if(lewel>3)
        {
            K7.setBackground(zakryta);
            K8.setBackground(zakryta);
            K9.setBackground(zakryta);
        }
        if(lewel>8)
        {
            K10.setBackground(zakryta);
            K11.setBackground(zakryta);
            K12.setBackground(zakryta);
        }
        if(lewel>13){
            K13.setBackground(zakryta);
            K14.setBackground(zakryta);
            K15.setBackground(zakryta);
            K16.setBackground(zakryta);
        }

    }

    void uruchomlewel(int lewel){
        GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
        Listakolorow=new ArrayList<>();
        losowaniekolorukart(lewel);
        przypiszkarty(lewel);
        pierwszyKlik();


    }
    void pierwszyKlik()
    {
        K1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
              OdwrcWszystkieKarty();
              kartaWybrana=1;
                drugiKlik();
            }
        });
        K2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                OdwrcWszystkieKarty();
                kartaWybrana=2;
                drugiKlik();
            }
        });
        K3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                OdwrcWszystkieKarty();
                kartaWybrana=3;
                drugiKlik();
            }
        });
        K4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                OdwrcWszystkieKarty();
                kartaWybrana=4;
                drugiKlik();
            }
        });
        K5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                OdwrcWszystkieKarty();
                kartaWybrana=5;
                drugiKlik();
            }
        });
        K6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                OdwrcWszystkieKarty();
                kartaWybrana=6;
                drugiKlik();
            }
        });
        if(lewel>3){
        try {
            K7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    OdwrcWszystkieKarty();
                    kartaWybrana = 7;
                    drugiKlik();
                }
            });
            K8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    OdwrcWszystkieKarty();
                    kartaWybrana = 8;
                    drugiKlik();
                }
            });
            K9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    OdwrcWszystkieKarty();
                    kartaWybrana = 9;
                    drugiKlik();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        if(lewel>8){
            try {
                K10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 10;
                        drugiKlik();
                    }
                });
                K11.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 11;
                        drugiKlik();
                    }
                });
                K12.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 12;
                        drugiKlik();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(lewel>8){
            try {
                K13.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 13;
                        drugiKlik();
                    }
                });
                K14.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 14;
                        drugiKlik();
                    }
                });
                K15.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 15;
                        drugiKlik();
                    }
                });
                K16.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        OdwrcWszystkieKarty();
                        kartaWybrana = 16;
                        drugiKlik();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    void drugiKlik()
    {
        K1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                relosuj();
                OdwrcWszystkieKarty();
                odwrucWybrana();
                trzecuKlik();
            }
        });
        K2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                relosuj();
                OdwrcWszystkieKarty();
                odwrucWybrana();
                trzecuKlik();
            }
        });
        K3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                relosuj();
                OdwrcWszystkieKarty();
                odwrucWybrana();
                trzecuKlik();
            }
        });
        K4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                relosuj();
                OdwrcWszystkieKarty();
                odwrucWybrana();
                trzecuKlik();
            }
        });
        K5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                relosuj();
                OdwrcWszystkieKarty();
                odwrucWybrana();
                trzecuKlik();
            }
        });
        K6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                relosuj();
                OdwrcWszystkieKarty();
                odwrucWybrana();
                trzecuKlik();
            }
        });
        if(lewel>3){
        try {
            K7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    relosuj();
                    OdwrcWszystkieKarty();
                    odwrucWybrana();
                    trzecuKlik();
                }
            });
            K8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    relosuj();
                    OdwrcWszystkieKarty();
                    odwrucWybrana();
                    trzecuKlik();
                }
            });
            K9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    relosuj();
                    OdwrcWszystkieKarty();
                    odwrucWybrana();
                    trzecuKlik();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        if(lewel>8){
            try {
                K10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
                K11.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
                K12.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(lewel>13){
            try {
                K13.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
                K14.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
                K15.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
                K16.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        relosuj();
                        OdwrcWszystkieKarty();
                        odwrucWybrana();
                        trzecuKlik();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    void trzecuKlik(){
        K1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Odpowiedz();
            }
        });
        K2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Odpowiedz();
            }
        });
        K3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Odpowiedz();
            }
        });
        K4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Odpowiedz();
            }
        });
        K5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Odpowiedz();
            }
        });
        K6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Odpowiedz();
            }
        });
        if(lewel>3){
        try {
            K7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Odpowiedz();
                }
            });
            K8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Odpowiedz();
                }
            });
            K9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Odpowiedz();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        if(lewel>8){
            try {
                K10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
                K11.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
                K12.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(lewel>13){
            try {
                K13.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
                K14.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
                K15.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
                K16.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Odpowiedz();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    void Odpowiedz(){


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(GameLI.this);
        View mView = getLayoutInflater().inflate(R.layout.wskarzkolor, null);
        ImageButton czer = (ImageButton) mView.findViewById(R.id.czer);
        ImageButton nieb = (ImageButton) mView.findViewById(R.id.nieb);
        ImageButton ziel = (ImageButton) mView.findViewById(R.id.ziel);
        ImageButton zul = (ImageButton) mView.findViewById(R.id.zul);
        ImageButton pom = (ImageButton) mView.findViewById(R.id.pom);
        ImageButton ruz = (ImageButton) mView.findViewById(R.id.ruz);

        if(lewel==1){ziel.setVisibility(View.GONE);zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==2){zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==3){pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}

        if(lewel==4){ziel.setVisibility(View.GONE);zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==5){zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==6){pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==7){ruz.setVisibility(View.GONE);}

        if(lewel==9){ziel.setVisibility(View.GONE);zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==10){zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==11){pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==12){ruz.setVisibility(View.GONE);}
        if(lewel==13){}
        if(lewel==14){ziel.setVisibility(View.GONE);zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==15){zul.setVisibility(View.GONE);pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==16){pom.setVisibility(View.GONE);ruz.setVisibility(View.GONE);}
        if(lewel==17){ruz.setVisibility(View.GONE);}
        if(lewel==18){}









        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();


        int kolorKarty = 0;

        if(kartaWybrana ==1){kolorKarty = Kk1;}
        if(kartaWybrana ==2){kolorKarty = Kk2;}
        if(kartaWybrana ==3){kolorKarty = Kk3;}
        if(kartaWybrana ==4){kolorKarty = Kk4;}
        if(kartaWybrana ==5){kolorKarty = Kk5;}
        if(kartaWybrana ==6){kolorKarty = Kk6;}
        if(kartaWybrana ==7){kolorKarty = Kk7;}
        if(kartaWybrana ==8){kolorKarty = Kk8;}
        if(kartaWybrana ==9){kolorKarty = Kk9;}
        if(kartaWybrana ==10){kolorKarty = Kk10;}
        if(kartaWybrana ==11){kolorKarty = Kk11;}
        if(kartaWybrana ==12){kolorKarty = Kk12;}
        if(kartaWybrana ==13){kolorKarty = Kk13;}
        if(kartaWybrana ==14){kolorKarty = Kk14;}
        if(kartaWybrana ==15){kolorKarty = Kk15;}
        if(kartaWybrana ==16){kolorKarty = Kk15;}
        if(kartaWybrana ==17){kolorKarty = Kk16;}
        final int kolorKartyWybranej=kolorKarty;



        czer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(kolorKartyWybranej==1){
                PunktyZaliczeniaLewelu++;
                    GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);

                if(PunktyZaliczeniaLewelu<3){
                    Powiadomienie(getResources().getString(R.string.gratulacje)+PunktyZaliczeniaLewelu+getResources().getString(R.string.tura_zaliczona));
                    zakryjkarty();
                    uruchomlewel(lewel);
                }
                if(PunktyZaliczeniaLewelu==3){
                    //Powiadomienie("Lewel zaliczony");
                    lewelZaliczony();}
                }
                else {Powiadomienie(getResources().getString(R.string.error));
                    PunktyZaliczeniaLewelu--; zakryjkarty();
                    uruchomlewel(lewel);}
                GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
                dialog.cancel();

            }
        });
        nieb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(kolorKartyWybranej==2){
                    PunktyZaliczeniaLewelu++;
                    GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);

                    if(PunktyZaliczeniaLewelu<3){
                        Powiadomienie(getResources().getString(R.string.gratulacje)+PunktyZaliczeniaLewelu+getResources().getString(R.string.tura_zaliczona));
                        zakryjkarty();
                        uruchomlewel(lewel);
                    }
                    if(PunktyZaliczeniaLewelu==3){
                      //  Powiadomienie("Lewel zaliczony");
                        lewelZaliczony();
                    }
                }
                else {Powiadomienie(getResources().getString(R.string.error));PunktyZaliczeniaLewelu--; zakryjkarty();
                    uruchomlewel(lewel);}
                GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
                dialog.cancel();
            }
        });
        ziel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(kolorKartyWybranej==3){
                    PunktyZaliczeniaLewelu++;
                    GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);

                    if(PunktyZaliczeniaLewelu<3){
                        Powiadomienie(getResources().getString(R.string.gratulacje)+PunktyZaliczeniaLewelu+getResources().getString(R.string.tura_zaliczona));
                        zakryjkarty();
                        uruchomlewel(lewel);
                    }
                    if(PunktyZaliczeniaLewelu==3){
                        lewelZaliczony();
                        //Powiadomienie("Lewel zaliczony");
                        }
                }
                else {Powiadomienie(getResources().getString(R.string.error));PunktyZaliczeniaLewelu--; zakryjkarty();
                    uruchomlewel(lewel);}
                GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
                dialog.cancel();
            }
        });
        zul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(kolorKartyWybranej==4){
                    PunktyZaliczeniaLewelu++;
                    GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);

                    if(PunktyZaliczeniaLewelu<3){
                        Powiadomienie(getResources().getString(R.string.gratulacje)+PunktyZaliczeniaLewelu+getResources().getString(R.string.tura_zaliczona));
                        zakryjkarty();
                        uruchomlewel(lewel);
                    }
                    if(PunktyZaliczeniaLewelu==3){
                        //Powiadomienie("Lewel zaliczony");
                        lewelZaliczony();
                    }
                }
                else {Powiadomienie(getResources().getString(R.string.error));PunktyZaliczeniaLewelu--; zakryjkarty();
                    uruchomlewel(lewel);}
                GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
                dialog.cancel();
            }
        });
        pom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(kolorKartyWybranej==5){
                    PunktyZaliczeniaLewelu++;
                    GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);

                    if(PunktyZaliczeniaLewelu<3){
                        Powiadomienie(getResources().getString(R.string.gratulacje)+PunktyZaliczeniaLewelu+getResources().getString(R.string.tura_zaliczona));
                        zakryjkarty();
                        uruchomlewel(lewel);
                    }
                    if(PunktyZaliczeniaLewelu==3){
                        //Powiadomienie("Lewel zaliczony");
                        lewelZaliczony();
                    }
                }
                else {Powiadomienie(getResources().getString(R.string.error));
                  if(PunktyDoZaliczeniaLewelu>0)
                  {
                      PunktyZaliczeniaLewelu--;
                  }
                  zakryjkarty();
                  uruchomlewel(lewel);}
                GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
                dialog.cancel();
            }
        });
        ruz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(kolorKartyWybranej==6){
                    PunktyZaliczeniaLewelu++;
                    GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);

                    if(PunktyZaliczeniaLewelu<3){
                        Powiadomienie(getResources().getString(R.string.gratulacje)+PunktyZaliczeniaLewelu+getResources().getString(R.string.tura_zaliczona));
                        zakryjkarty();
                        uruchomlewel(lewel);
                    }
                    if(PunktyZaliczeniaLewelu==3){
                        //Powiadomienie("Lewel zaliczony");
                        lewelZaliczony();
                    }
                }
                else {Powiadomienie(getResources().getString(R.string.error));PunktyZaliczeniaLewelu--; zakryjkarty();
                    uruchomlewel(lewel);}
                GurnabelkaPunkty.setText(getResources().getString(R.string.do_zaliczenia_lew)+" "+PunktyZaliczeniaLewelu+"/"+PunktyDoZaliczeniaLewelu);
                dialog.cancel();
            }
        });


    }

    void lewelZaliczony(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(GameLI.this);
        View mView = getLayoutInflater().inflate(R.layout.lewelzaliczony, null);
        Button ok = (Button) mView.findViewById(R.id.KOMlewOK);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                dialog.cancel();
                finish();
            }
        });

        if(lewel==1){  editorpref.putInt("lewel1",1);editorpref.apply();}
        if(lewel==2){  editorpref.putInt("lewel2",1);editorpref.apply();}
        if(lewel==3){  editorpref.putInt("lewel3",1);editorpref.apply();}
        if(lewel==4){  editorpref.putInt("lewel4",1);editorpref.apply();}
        if(lewel==5){  editorpref.putInt("lewel5",1);editorpref.apply();}
        if(lewel==6){  editorpref.putInt("lewel6",1);editorpref.apply();}
        if(lewel==7){  editorpref.putInt("lewel7",1);editorpref.apply();}
        if(lewel==8){  editorpref.putInt("lewel8",1);editorpref.apply();}
        if(lewel==9){  editorpref.putInt("lewel9",1);editorpref.apply();}
        if(lewel==10){  editorpref.putInt("lewel10",1);editorpref.apply();}
        if(lewel==11){  editorpref.putInt("lewel11",1);editorpref.apply();}
        if(lewel==12){  editorpref.putInt("lewel12",1);editorpref.apply();}
        if(lewel==13){  editorpref.putInt("lewel13",1);editorpref.apply();}
        if(lewel==14){  editorpref.putInt("lewel14",1);editorpref.apply();}
        if(lewel==15){  editorpref.putInt("lewel15",1);editorpref.apply();}
        if(lewel==16){  editorpref.putInt("lewel16",1);editorpref.apply();}
        if(lewel==17){  editorpref.putInt("lewel17",1);editorpref.apply();}
        if(lewel==18){  editorpref.putInt("lewel15",1);editorpref.apply();}
        if(lewel==19){  editorpref.putInt("lewel15",1);editorpref.apply();}






    }


    void odwrucWybrana(){
        if(kartaWybrana==1){
            K1.setBackground(zakryta);
        }
        if(kartaWybrana==2){
            K2.setBackground(zakryta);
        }
        if(kartaWybrana==3){
            K3.setBackground(zakryta);
        }
        if(kartaWybrana==4){
            K4.setBackground(zakryta);
        }
        if(kartaWybrana==5){
            K5.setBackground(zakryta);
        }
        if(kartaWybrana==6){
            K6.setBackground(zakryta);
        }
        if(kartaWybrana==7){
            K7.setBackground(zakryta);
        }
        if(kartaWybrana==8){
            K8.setBackground(zakryta);
        }
        if(kartaWybrana==9){
            K9.setBackground(zakryta);
        }
        if(kartaWybrana==10){
            K10.setBackground(zakryta);
        }
        if(kartaWybrana==11){
            K11.setBackground(zakryta);
        }
        if(kartaWybrana==12){
            K12.setBackground(zakryta);
        }
        if(kartaWybrana==13){
            K13.setBackground(zakryta);
        }
        if(kartaWybrana==14){
            K14.setBackground(zakryta);
        }
        if(kartaWybrana==15){
            K15.setBackground(zakryta);
        }
        if(kartaWybrana==16){
            K16.setBackground(zakryta);
        }




    }

    void OdwrcWszystkieKarty(){
        Odwruckarte(K1,Kk1);
        Log.d("OdwrcKarte","K1: " +Kk1);
        Odwruckarte(K2,Kk2);
        Log.d("OdwrcKarte","K2: " +Kk2);
        Odwruckarte(K3,Kk3);
        Log.d("OdwrcKarte","K3: " +Kk3);
        Odwruckarte(K4,Kk4);
        Log.d("OdwrcKarte","K4: " +Kk4);
        Odwruckarte(K5,Kk5);
        Log.d("OdwrcKarte","K5: " +Kk5);
        Odwruckarte(K6,Kk6);
        Log.d("OdwrcKarte","K6: " +Kk6);
        try {
        Odwruckarte(K7,Kk7);
            Log.d("OdwrcKarte","K7: " +Kk7);
        Odwruckarte(K8,Kk8);
            Log.d("OdwrcKarte","K8: " +Kk8);
        Odwruckarte(K9,Kk9);
            Log.d("OdwrcKarte","K9: " +Kk9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Odwruckarte(K10,Kk10);
            Log.d("OdwrcKarte","K10: " +Kk10);
            Odwruckarte(K11,Kk11);
            Log.d("OdwrcKarte","K11: " +Kk11);
            Odwruckarte(K12,Kk12);
            Log.d("OdwrcKarte","K12: " +Kk12);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Odwruckarte(K13,Kk13);
            Log.d("OdwrcKarte","K13: " +Kk13);
            Odwruckarte(K14,Kk14);
            Log.d("OdwrcKarte","K14: " +Kk14);
            Odwruckarte(K15,Kk15);
            Log.d("OdwrcKarte","K15: " +Kk15);
            Odwruckarte(K16,Kk16);
            Log.d("OdwrcKarte","K16: " +Kk16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    void przypiszkarty(int lewel){
        if(lewel<=3){
            K1=findViewById(R.id.L1P1);
            K2=findViewById(R.id.L1P2);
            K3=findViewById(R.id.L1P3);
            K4=findViewById(R.id.L1P4);
            K5=findViewById(R.id.L1P5);
            K6=findViewById(R.id.L1P6);
        }
        if(lewel>3)
        {
            K1=findViewById(R.id.L4P1);
            K2=findViewById(R.id.L4P2);
            K3=findViewById(R.id.L4P3);
            K4=findViewById(R.id.L4P4);
            K5=findViewById(R.id.L4P5);
            K6=findViewById(R.id.L4P6);
            K7=findViewById(R.id.L4P7);
            K8=findViewById(R.id.L4P8);
            K9=findViewById(R.id.L4P9);
        }
        if(lewel>8){
            K10=findViewById(R.id.L4P10);
            K11=findViewById(R.id.L4P11);
            K12=findViewById(R.id.L4P12);
        }
        if(lewel>13){
            K13=findViewById(R.id.L4P13);
            K14=findViewById(R.id.L4P14);
            K15=findViewById(R.id.L4P15);
            K16=findViewById(R.id.L4P16);
        }

    }

    void Odwruckarte(ImageButton karta, int kolor){
        if(kolor==1){ karta.setBackground(czerwona);}
        if(kolor==2){ karta.setBackground(niebieska);}
        if(kolor==3){ karta.setBackground(zielona);}
        if(kolor==4){ karta.setBackground(zulta);}
        if(kolor==5){ karta.setBackground(pomaranczowa);}
        if(kolor==6){ karta.setBackground(ruzowa);}
    }


    void losowaniekolorukart(int lewel){

        Kk1=losujkolor(lewel);
        Kk2=losujkolor(lewel);
        Kk3=losujkolor(lewel);
        Kk4=losujkolor(lewel);
        Kk5=losujkolor(lewel);
        Kk6=losujkolor(lewel);
        Listakolorow.add(Kk1);
        Listakolorow.add(Kk2);
        Listakolorow.add(Kk3);
        Listakolorow.add(Kk4);
        Listakolorow.add(Kk5);
        Listakolorow.add(Kk6);
        if(lewel>3)
        {
            Kk7=losujkolor(lewel);
            Kk8=losujkolor(lewel);
            Kk9=losujkolor(lewel);
            Listakolorow.add(Kk7);
            Listakolorow.add(Kk8);
            Listakolorow.add(Kk9);
        }
        if(lewel>8){
            Kk10=losujkolor(lewel);
            Kk11=losujkolor(lewel);
            Kk12=losujkolor(lewel);
            Listakolorow.add(Kk10);
            Listakolorow.add(Kk11);
            Listakolorow.add(Kk12);
        }
        if(lewel>13){
            Kk13=losujkolor(lewel);
            Kk14=losujkolor(lewel);
            Kk15=losujkolor(lewel);
            Kk16=losujkolor(lewel);
            Listakolorow.add(Kk13);
            Listakolorow.add(Kk14);
            Listakolorow.add(Kk15);
            Listakolorow.add(Kk16);
        }

    }

    int losujkolor(int lewel){

        Random r = new Random();
        int los=0;
        if(lewel==1){los = r.nextInt(2)+1;}
        if(lewel==2){los = r.nextInt(3)+1;}
        if(lewel==3){los = r.nextInt(4)+1;}
        if(lewel==4){los = r.nextInt(2)+1;}
        if(lewel==5){los = r.nextInt(3)+1;}
        if(lewel==6){los = r.nextInt(4)+1;}
        if(lewel==7){los = r.nextInt(5)+1;}
        if(lewel==8){los = r.nextInt(6)+1;}
        if(lewel==9){los = r.nextInt(2)+1;}
        if(lewel==10){los = r.nextInt(3)+1;}
        if(lewel==11){los = r.nextInt(4)+1;}
        if(lewel==12){los = r.nextInt(5)+1;}
        if(lewel==13){los = r.nextInt(6)+1;}
        ///lewel 14+
        if(lewel==14){los = r.nextInt(2)+1;}
        if(lewel==15){los = r.nextInt(3)+1;}
        if(lewel==16){los = r.nextInt(4)+1;}
        if(lewel==17){los = r.nextInt(5)+1;}
        if(lewel==18){los = r.nextInt(6)+1;}
        //
        return los;
    }

    void relosuj(){
        int Tk1,Tk2,Tk3,Tk4,Tk5,Tk6,Tk7,Tk8,Tk9;

        List<Integer> psl = new ArrayList<>();
        int pow = 0;
        int cykle=0;

        for(int i=0;i<Listakolorow.size();i++){
            Random r = new Random();
            int los=r.nextInt(Listakolorow.size());
            Log.d("LOS","los:"+los);
            if(!psl.contains(los))
            {
                if(i==0){ Kk1 = Listakolorow.get(los);}
                if(i==1){ Kk2 = Listakolorow.get(los);}
                if(i==2){ Kk3 = Listakolorow.get(los);}
                if(i==3){ Kk4 = Listakolorow.get(los);}
                if(i==4){ Kk5 = Listakolorow.get(los);}
                if(i==5){ Kk6 = Listakolorow.get(los);}
                if(i==6){ Kk7 = Listakolorow.get(los);}
                if(i==7){ Kk8 = Listakolorow.get(los);}
                if(i==8){ Kk9 = Listakolorow.get(los);}
                if(i==9){ Kk10 = Listakolorow.get(los);}
                if(i==10){ Kk11 = Listakolorow.get(los);}
                if(i==11){ Kk12 = Listakolorow.get(los);}
                if(i==12){ Kk13 = Listakolorow.get(los);}
                if(i==13){ Kk14 = Listakolorow.get(los);}
                if(i==14){ Kk15 = Listakolorow.get(los);}
                if(i==15){ Kk16 = Listakolorow.get(los);}
                Log.d("I","i:"+i);
                psl.add(los);
                cykle++;
            }else {i--;pow++;}
        }
        //Powiadomienie("powturka:" + pow +"cyk"+cykle+"los");


    }

    public void ZapiszPref(int lewelunlok){
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences("Swinka", MODE_PRIVATE).edit();
        editor.putInt("lewelunlok",lewelunlok);
        editor.apply();
    }



    public void Powiadomienie(String wiadomosc){
        Snackbar.make(this.findViewById(android.R.id.content),
                wiadomosc,
                Snackbar.LENGTH_SHORT)
                .setDuration(5000).setAction("Action", null).show();
    }




}

