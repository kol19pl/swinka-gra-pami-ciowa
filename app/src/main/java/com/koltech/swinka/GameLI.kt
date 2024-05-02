package com.koltech.swinka

import android.app.AlertDialog
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.games.Games
import com.google.android.material.snackbar.Snackbar
import java.util.Random

class GameLI : AppCompatActivity() {
    private var adView: AdView? = null
    private var adContainerView: FrameLayout? = null

    ///kart storedz
    var K1: ImageButton? = null
    var K2: ImageButton? = null
    var K3: ImageButton? = null
    var K4: ImageButton? = null
    var K5: ImageButton? = null
    var K6: ImageButton? = null
    var K7: ImageButton? = null
    var K8: ImageButton? = null
    var K9: ImageButton? = null
    var K10: ImageButton? = null
    var K11: ImageButton? = null
    var K12: ImageButton? = null
    var K13: ImageButton? = null
    var K14: ImageButton? = null
    var K15: ImageButton? = null
    var K16: ImageButton? = null
    var K17: ImageButton? = null
    var K20: ImageButton? = null

    //  Resources res;
    var zakryta: Drawable? = null
    var czerwona: Drawable? = null
    var niebieska: Drawable? = null
    var zielona: Drawable? = null
    var zulta: Drawable? = null
    var pomaranczowa: Drawable? = null
    var ruzowa: Drawable? = null

    var GurnabelkaPunkty: TextView? = null

    //int[] kolory6 = new int[6];
    var Listakolorow: MutableList<Int>? = null


    var editorpref: SharedPreferences.Editor? = null

    //Kolory kart
    var Kk1: Int? = null
    var Kk2: Int? = null
    var Kk3: Int? = null
    var Kk4: Int? = null
    var Kk5: Int? = null
    var Kk6: Int? = null
    var Kk7: Int? = null
    var Kk8: Int? = null
    var Kk9: Int? = null
    var Kk10: Int? = null
    var Kk11: Int? = null
    var Kk12: Int? = null
    var Kk13: Int? = null
    var Kk14: Int? = null
    var Kk15: Int? = null
    var Kk16: Int? = null
    var Kk17: Int? = null
    var Kk18: Int? = null
    var Kk19: Int? = null
    var Kk20: Int? = null

    //1 czerwona
    //2 niebieska
    //3 zielona
    //4 zulta
    var kartaWybrana: Int = 0

    //int kolorKartyWybranej=8;
    var PunktyZaliczeniaLewelu: Int = 0

    var PunktyDoZaliczeniaLewelu: Int = 3


    var lewel: Int = 0

    private val mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        if (extras != null) {
            val value = extras.getString("Lewel")
            lewel = value!!.toInt()
        }

        setup()

        if (lewel == 1) {
            StartL1()
        }
        if (lewel == 2) {
            StartL2()
        }
        if (lewel == 3) {
            StartL3()
        }
        if (lewel > 3 && lewel < 9) {
            PunktyDoZaliczeniaLewelu = 5
            StartL4UP()
        }
        if (lewel > 8 && lewel < 14) {
            PunktyDoZaliczeniaLewelu = 5
            StartL9UP()
        }
        if (lewel > 13) {
            PunktyDoZaliczeniaLewelu = 5
            StartL14UP()
        }


        MobileAds.initialize(this) { }
        adContainerView = findViewById(R.id.adCongame)

        // Since we're loading the banner based on the adContainerView size, we need to wait until this
        // view is laid out before we can get the width.

        (adContainerView as? FrameLayout)?.post(Runnable { loadBanner() })


        //   signInSilently();
    }

    fun StartL1() {
        setContentView(R.layout.leweljeden)
        GurnabelkaPunkty = findViewById<View>(R.id.BelkaGpunkty) as TextView
        uruchomlewel(lewel)
    }

    fun StartL2() {
        setContentView(R.layout.leweljeden)
        GurnabelkaPunkty = findViewById<View>(R.id.BelkaGpunkty) as TextView
        uruchomlewel(lewel)
    }

    fun StartL3() {
        setContentView(R.layout.leweljeden)
        GurnabelkaPunkty = findViewById<View>(R.id.BelkaGpunkty) as TextView

        uruchomlewel(lewel)
    }

    fun StartL4UP() {
        setContentView(R.layout.lewelcztery)
        GurnabelkaPunkty = findViewById<View>(R.id.BelkaGpunkty) as TextView
        uruchomlewel(lewel)
    }

    fun StartL9UP() {
        setContentView(R.layout.leweldziewienc)
        GurnabelkaPunkty = findViewById<View>(R.id.BelkaGpunkty) as TextView
        uruchomlewel(lewel)
    }

    fun StartL14UP() {
        setContentView(R.layout.lewelczternasty)
        GurnabelkaPunkty = findViewById<View>(R.id.BelkaGpunkty) as TextView
        uruchomlewel(lewel)
    }


    fun setup() {
        editorpref = applicationContext.getSharedPreferences("Swinka", MODE_PRIVATE).edit()

        val res = resources
        zakryta = ResourcesCompat.getDrawable(res, R.drawable.zakryta, null)
        czerwona = ResourcesCompat.getDrawable(res, R.drawable.czerwona, null)
        niebieska = ResourcesCompat.getDrawable(res, R.drawable.niebieska, null)
        zielona = ResourcesCompat.getDrawable(res, R.drawable.zielona, null)
        zulta = ResourcesCompat.getDrawable(res, R.drawable.zulta, null)
        pomaranczowa = ResourcesCompat.getDrawable(res, R.drawable.pomaranczowa, null)
        ruzowa = ResourcesCompat.getDrawable(res, R.drawable.ruzowa, null)
    }

    fun zakryjkarty() {
        K1!!.background = zakryta
        K2!!.background = zakryta
        K3!!.background = zakryta
        K4!!.background = zakryta
        K5!!.background = zakryta
        K6!!.background = zakryta
        if (lewel > 3) {
            K7!!.background = zakryta
            K8!!.background = zakryta
            K9!!.background = zakryta
        }
        if (lewel > 8) {
            K10!!.background = zakryta
            K11!!.background = zakryta
            K12!!.background = zakryta
        }
        if (lewel > 13) {
            K13!!.background = zakryta
            K14!!.background = zakryta
            K15!!.background = zakryta
            K16!!.background = zakryta
        }
    }

    fun uruchomlewel(lewel: Int) {
        GurnabelkaPunkty!!.text =
            resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
        Listakolorow = ArrayList()
        losowaniekolorukart(lewel)
        przypiszkarty(lewel)
        pierwszyKlik()
    }

    fun pierwszyKlik() {
        K1!!.setOnClickListener {
            OdwrcWszystkieKarty()
            kartaWybrana = 1
            drugiKlik()
        }
        K2!!.setOnClickListener {
            OdwrcWszystkieKarty()
            kartaWybrana = 2
            drugiKlik()
        }
        K3!!.setOnClickListener {
            OdwrcWszystkieKarty()
            kartaWybrana = 3
            drugiKlik()
        }
        K4!!.setOnClickListener {
            OdwrcWszystkieKarty()
            kartaWybrana = 4
            drugiKlik()
        }
        K5!!.setOnClickListener {
            OdwrcWszystkieKarty()
            kartaWybrana = 5
            drugiKlik()
        }
        K6!!.setOnClickListener {
            OdwrcWszystkieKarty()
            kartaWybrana = 6
            drugiKlik()
        }
        if (lewel > 3) {
            try {
                K7!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 7
                    drugiKlik()
                }
                K8!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 8
                    drugiKlik()
                }
                K9!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 9
                    drugiKlik()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (lewel > 8) {
            try {
                K10!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 10
                    drugiKlik()
                }
                K11!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 11
                    drugiKlik()
                }
                K12!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 12
                    drugiKlik()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (lewel > 8) {
            try {
                K13!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 13
                    drugiKlik()
                }
                K14!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 14
                    drugiKlik()
                }
                K15!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 15
                    drugiKlik()
                }
                K16!!.setOnClickListener {
                    OdwrcWszystkieKarty()
                    kartaWybrana = 16
                    drugiKlik()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun drugiKlik() {
        K1!!.setOnClickListener {
            relosuj()
            OdwrcWszystkieKarty()
            odwrucWybrana()
            trzecuKlik()
        }
        K2!!.setOnClickListener {
            relosuj()
            OdwrcWszystkieKarty()
            odwrucWybrana()
            trzecuKlik()
        }
        K3!!.setOnClickListener {
            relosuj()
            OdwrcWszystkieKarty()
            odwrucWybrana()
            trzecuKlik()
        }
        K4!!.setOnClickListener {
            relosuj()
            OdwrcWszystkieKarty()
            odwrucWybrana()
            trzecuKlik()
        }
        K5!!.setOnClickListener {
            relosuj()
            OdwrcWszystkieKarty()
            odwrucWybrana()
            trzecuKlik()
        }
        K6!!.setOnClickListener {
            relosuj()
            OdwrcWszystkieKarty()
            odwrucWybrana()
            trzecuKlik()
        }
        if (lewel > 3) {
            try {
                K7!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K8!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K9!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (lewel > 8) {
            try {
                K10!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K11!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K12!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (lewel > 13) {
            try {
                K13!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K14!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K15!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
                K16!!.setOnClickListener {
                    relosuj()
                    OdwrcWszystkieKarty()
                    odwrucWybrana()
                    trzecuKlik()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun trzecuKlik() {
        K1!!.setOnClickListener { Odpowiedz() }
        K2!!.setOnClickListener { Odpowiedz() }
        K3!!.setOnClickListener { Odpowiedz() }
        K4!!.setOnClickListener { Odpowiedz() }
        K5!!.setOnClickListener { Odpowiedz() }
        K6!!.setOnClickListener { Odpowiedz() }
        if (lewel > 3) {
            try {
                K7!!.setOnClickListener { Odpowiedz() }
                K8!!.setOnClickListener { Odpowiedz() }
                K9!!.setOnClickListener { Odpowiedz() }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (lewel > 8) {
            try {
                K10!!.setOnClickListener { Odpowiedz() }
                K11!!.setOnClickListener { Odpowiedz() }
                K12!!.setOnClickListener { Odpowiedz() }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (lewel > 13) {
            try {
                K13!!.setOnClickListener { Odpowiedz() }
                K14!!.setOnClickListener { Odpowiedz() }
                K15!!.setOnClickListener { Odpowiedz() }
                K16!!.setOnClickListener { Odpowiedz() }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun Odpowiedz() {
        val mBuilder = AlertDialog.Builder(this@GameLI)
        val mView = layoutInflater.inflate(R.layout.wskarzkolor, null)
        val czer = mView.findViewById<View>(R.id.czer) as ImageButton
        val nieb = mView.findViewById<View>(R.id.nieb) as ImageButton
        val ziel = mView.findViewById<View>(R.id.ziel) as ImageButton
        val zul = mView.findViewById<View>(R.id.zul) as ImageButton
        val pom = mView.findViewById<View>(R.id.pom) as ImageButton
        val ruz = mView.findViewById<View>(R.id.ruz) as ImageButton

        if (lewel == 1) {
            ziel.visibility = View.GONE
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 2) {
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 3) {
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }

        if (lewel == 4) {
            ziel.visibility = View.GONE
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 5) {
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 6) {
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 7) {
            ruz.visibility = View.GONE
        }

        if (lewel == 9) {
            ziel.visibility = View.GONE
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 10) {
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 11) {
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 12) {
            ruz.visibility = View.GONE
        }
        if (lewel == 13) {
        }
        if (lewel == 14) {
            ziel.visibility = View.GONE
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 15) {
            zul.visibility = View.GONE
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 16) {
            pom.visibility = View.GONE
            ruz.visibility = View.GONE
        }
        if (lewel == 17) {
            ruz.visibility = View.GONE
        }
        if (lewel == 18) {
        }









        mBuilder.setView(mView)
        val dialog = mBuilder.create()
        dialog.show()


        var kolorKarty = 0

        if (kartaWybrana == 1) {
            kolorKarty = Kk1!!
        }
        if (kartaWybrana == 2) {
            kolorKarty = Kk2!!
        }
        if (kartaWybrana == 3) {
            kolorKarty = Kk3!!
        }
        if (kartaWybrana == 4) {
            kolorKarty = Kk4!!
        }
        if (kartaWybrana == 5) {
            kolorKarty = Kk5!!
        }
        if (kartaWybrana == 6) {
            kolorKarty = Kk6!!
        }
        if (kartaWybrana == 7) {
            kolorKarty = Kk7!!
        }
        if (kartaWybrana == 8) {
            kolorKarty = Kk8!!
        }
        if (kartaWybrana == 9) {
            kolorKarty = Kk9!!
        }
        if (kartaWybrana == 10) {
            kolorKarty = Kk10!!
        }
        if (kartaWybrana == 11) {
            kolorKarty = Kk11!!
        }
        if (kartaWybrana == 12) {
            kolorKarty = Kk12!!
        }
        if (kartaWybrana == 13) {
            kolorKarty = Kk13!!
        }
        if (kartaWybrana == 14) {
            kolorKarty = Kk14!!
        }
        if (kartaWybrana == 15) {
            kolorKarty = Kk15!!
        }
        if (kartaWybrana == 16) {
            kolorKarty = Kk15!!
        }
        if (kartaWybrana == 17) {
            kolorKarty = Kk16!!
        }
        val kolorKartyWybranej = kolorKarty



        czer.setOnClickListener {
            if (kolorKartyWybranej == 1) {
                PunktyZaliczeniaLewelu++
                val punkty = " $PunktyZaliczeniaLewelu//$PunktyDoZaliczeniaLewelu"
                GurnabelkaPunkty!!.text = resources.getString(R.string.do_zaliczenia_lew) + punkty

                if (PunktyZaliczeniaLewelu < 3) {
                    Powiadomienie(
                        resources.getString(R.string.gratulacje) + PunktyZaliczeniaLewelu + resources.getString(
                            R.string.tura_zaliczona
                        )
                    )
                    zakryjkarty()
                    uruchomlewel(lewel)
                }
                if (PunktyZaliczeniaLewelu == 3) {
                    //Powiadomienie("Lewel zaliczony");
                    lewelZaliczony()
                }
            } else {
                Powiadomienie(resources.getString(R.string.error))
                PunktyZaliczeniaLewelu--
                zakryjkarty()
                uruchomlewel(lewel)
            }
            GurnabelkaPunkty!!.text =
                resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
            dialog.cancel()
        }
        nieb.setOnClickListener {
            if (kolorKartyWybranej == 2) {
                PunktyZaliczeniaLewelu++
                GurnabelkaPunkty!!.text =
                    resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu

                if (PunktyZaliczeniaLewelu < 3) {
                    Powiadomienie(
                        resources.getString(R.string.gratulacje) + PunktyZaliczeniaLewelu + resources.getString(
                            R.string.tura_zaliczona
                        )
                    )
                    zakryjkarty()
                    uruchomlewel(lewel)
                }
                if (PunktyZaliczeniaLewelu == 3) {
                    //  Powiadomienie("Lewel zaliczony");
                    lewelZaliczony()
                }
            } else {
                Powiadomienie(resources.getString(R.string.error))
                PunktyZaliczeniaLewelu--
                zakryjkarty()
                uruchomlewel(lewel)
            }
            GurnabelkaPunkty!!.text =
                resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
            dialog.cancel()
        }
        ziel.setOnClickListener {
            if (kolorKartyWybranej == 3) {
                PunktyZaliczeniaLewelu++
                GurnabelkaPunkty!!.text =
                    resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu

                if (PunktyZaliczeniaLewelu < 3) {
                    Powiadomienie(
                        resources.getString(R.string.gratulacje) + PunktyZaliczeniaLewelu + resources.getString(
                            R.string.tura_zaliczona
                        )
                    )
                    zakryjkarty()
                    uruchomlewel(lewel)
                }
                if (PunktyZaliczeniaLewelu == 3) {
                    lewelZaliczony()
                    //Powiadomienie("Lewel zaliczony");
                }
            } else {
                Powiadomienie(resources.getString(R.string.error))
                PunktyZaliczeniaLewelu--
                zakryjkarty()
                uruchomlewel(lewel)
            }
            GurnabelkaPunkty!!.text =
                resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
            dialog.cancel()
        }
        zul.setOnClickListener {
            if (kolorKartyWybranej == 4) {
                PunktyZaliczeniaLewelu++
                GurnabelkaPunkty!!.text =
                    resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu

                if (PunktyZaliczeniaLewelu < 3) {
                    Powiadomienie(
                        resources.getString(R.string.gratulacje) + PunktyZaliczeniaLewelu + resources.getString(
                            R.string.tura_zaliczona
                        )
                    )
                    zakryjkarty()
                    uruchomlewel(lewel)
                }
                if (PunktyZaliczeniaLewelu == 3) {
                    //Powiadomienie("Lewel zaliczony");
                    lewelZaliczony()
                }
            } else {
                Powiadomienie(resources.getString(R.string.error))
                PunktyZaliczeniaLewelu--
                zakryjkarty()
                uruchomlewel(lewel)
            }
            GurnabelkaPunkty!!.text =
                resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
            dialog.cancel()
        }
        pom.setOnClickListener {
            if (kolorKartyWybranej == 5) {
                PunktyZaliczeniaLewelu++
                GurnabelkaPunkty!!.text =
                    resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu

                if (PunktyZaliczeniaLewelu < 3) {
                    Powiadomienie(
                        resources.getString(R.string.gratulacje) + PunktyZaliczeniaLewelu + resources.getString(
                            R.string.tura_zaliczona
                        )
                    )
                    zakryjkarty()
                    uruchomlewel(lewel)
                }
                if (PunktyZaliczeniaLewelu == 3) {
                    //Powiadomienie("Lewel zaliczony");
                    lewelZaliczony()
                }
            } else {
                Powiadomienie(resources.getString(R.string.error))
                if (PunktyDoZaliczeniaLewelu > 0) {
                    PunktyZaliczeniaLewelu--
                }
                zakryjkarty()
                uruchomlewel(lewel)
            }
            GurnabelkaPunkty!!.text =
                resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
            dialog.cancel()
        }
        ruz.setOnClickListener {
            if (kolorKartyWybranej == 6) {
                PunktyZaliczeniaLewelu++
                GurnabelkaPunkty!!.text =
                    resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu

                if (PunktyZaliczeniaLewelu < 3) {
                    Powiadomienie(
                        resources.getString(R.string.gratulacje) + PunktyZaliczeniaLewelu + resources.getString(
                            R.string.tura_zaliczona
                        )
                    )
                    zakryjkarty()
                    uruchomlewel(lewel)
                }
                if (PunktyZaliczeniaLewelu == 3) {
                    //Powiadomienie("Lewel zaliczony");
                    lewelZaliczony()
                }
            } else {
                Powiadomienie(resources.getString(R.string.error))
                PunktyZaliczeniaLewelu--
                zakryjkarty()
                uruchomlewel(lewel)
            }
            GurnabelkaPunkty!!.text =
                resources.getString(R.string.do_zaliczenia_lew) + " " + PunktyZaliczeniaLewelu + "/" + PunktyDoZaliczeniaLewelu
            dialog.cancel()
        }
    }

    fun lewelZaliczony() {
        val mBuilder = AlertDialog.Builder(this@GameLI)
        val mView = layoutInflater.inflate(R.layout.lewelzaliczony, null)
        val ok = mView.findViewById<View>(R.id.KOMlewOK) as Button

        mBuilder.setView(mView)
        val dialog = mBuilder.create()
        dialog.show()

        ok.setOnClickListener {
            dialog.cancel()
            finish()
        }

        if (lewel == 1) {
            editorpref!!.putInt("lewel1", 1)
            editorpref!!.apply()
        }
        if (lewel == 2) {
            editorpref!!.putInt("lewel2", 1)
            editorpref!!.apply()
        }
        if (lewel == 3) {
            editorpref!!.putInt("lewel3", 1)
            editorpref!!.apply()
        }
        if (lewel == 4) {
            editorpref!!.putInt("lewel4", 1)
            editorpref!!.apply()
        }
        if (lewel == 5) {
            editorpref!!.putInt("lewel5", 1)
            editorpref!!.apply()
        }
        if (lewel == 6) {
            editorpref!!.putInt("lewel6", 1)
            editorpref!!.apply()
        }
        if (lewel == 7) {
            editorpref!!.putInt("lewel7", 1)
            editorpref!!.apply()
        }
        if (lewel == 8) {
            editorpref!!.putInt("lewel8", 1)
            editorpref!!.apply()
        }
        if (lewel == 9) {
            editorpref!!.putInt("lewel9", 1)
            editorpref!!.apply()
        }
        if (lewel == 10) {
            editorpref!!.putInt("lewel10", 1)
            editorpref!!.apply()
        }
        if (lewel == 11) {
            editorpref!!.putInt("lewel11", 1)
            editorpref!!.apply()
        }
        if (lewel == 12) {
            editorpref!!.putInt("lewel12", 1)
            editorpref!!.apply()
        }
        if (lewel == 13) {
            editorpref!!.putInt("lewel13", 1)
            editorpref!!.apply()
        }
        if (lewel == 14) {
            editorpref!!.putInt("lewel14", 1)
            editorpref!!.apply()
        }
        if (lewel == 15) {
            editorpref!!.putInt("lewel15", 1)
            editorpref!!.apply()
        }
        if (lewel == 16) {
            editorpref!!.putInt("lewel16", 1)
            editorpref!!.apply()
        }
        if (lewel == 17) {
            editorpref!!.putInt("lewel17", 1)
            editorpref!!.apply()
        }
        if (lewel == 18) {
            editorpref!!.putInt("lewel18", 1)
            editorpref!!.apply()
        }
        if (lewel == 19) {
            editorpref!!.putInt("lewel19", 1)
            editorpref!!.apply()
        }
    }

    fun Achivment(Acz: String?) {
        Games.getAchievementsClient(this, GoogleSignIn.getLastSignedInAccount(this)!!)
            .unlock(Acz!!)
    }


    fun odwrucWybrana() {
        if (kartaWybrana == 1) {
            K1!!.background = zakryta
        }
        if (kartaWybrana == 2) {
            K2!!.background = zakryta
        }
        if (kartaWybrana == 3) {
            K3!!.background = zakryta
        }
        if (kartaWybrana == 4) {
            K4!!.background = zakryta
        }
        if (kartaWybrana == 5) {
            K5!!.background = zakryta
        }
        if (kartaWybrana == 6) {
            K6!!.background = zakryta
        }
        if (kartaWybrana == 7) {
            K7!!.background = zakryta
        }
        if (kartaWybrana == 8) {
            K8!!.background = zakryta
        }
        if (kartaWybrana == 9) {
            K9!!.background = zakryta
        }
        if (kartaWybrana == 10) {
            K10!!.background = zakryta
        }
        if (kartaWybrana == 11) {
            K11!!.background = zakryta
        }
        if (kartaWybrana == 12) {
            K12!!.background = zakryta
        }
        if (kartaWybrana == 13) {
            K13!!.background = zakryta
        }
        if (kartaWybrana == 14) {
            K14!!.background = zakryta
        }
        if (kartaWybrana == 15) {
            K15!!.background = zakryta
        }
        if (kartaWybrana == 16) {
            K16!!.background = zakryta
        }
    }

    fun OdwrcWszystkieKarty() {
        Odwruckarte(K1, Kk1!!)
        Log.d("OdwrcKarte", "K1: $Kk1")
        Odwruckarte(K2, Kk2!!)
        Log.d("OdwrcKarte", "K2: $Kk2")
        Odwruckarte(K3, Kk3!!)
        Log.d("OdwrcKarte", "K3: $Kk3")
        Odwruckarte(K4, Kk4!!)
        Log.d("OdwrcKarte", "K4: $Kk4")
        Odwruckarte(K5, Kk5!!)
        Log.d("OdwrcKarte", "K5: $Kk5")
        Odwruckarte(K6, Kk6!!)
        Log.d("OdwrcKarte", "K6: $Kk6")
        try {
            Odwruckarte(K7, Kk7!!)
            Log.d("OdwrcKarte", "K7: $Kk7")
            Odwruckarte(K8, Kk8!!)
            Log.d("OdwrcKarte", "K8: $Kk8")
            Odwruckarte(K9, Kk9!!)
            Log.d("OdwrcKarte", "K9: $Kk9")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            Odwruckarte(K10, Kk10!!)
            Log.d("OdwrcKarte", "K10: $Kk10")
            Odwruckarte(K11, Kk11!!)
            Log.d("OdwrcKarte", "K11: $Kk11")
            Odwruckarte(K12, Kk12!!)
            Log.d("OdwrcKarte", "K12: $Kk12")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            Odwruckarte(K13, Kk13!!)
            Log.d("OdwrcKarte", "K13: $Kk13")
            Odwruckarte(K14, Kk14!!)
            Log.d("OdwrcKarte", "K14: $Kk14")
            Odwruckarte(K15, Kk15!!)
            Log.d("OdwrcKarte", "K15: $Kk15")
            Odwruckarte(K16, Kk16!!)
            Log.d("OdwrcKarte", "K16: $Kk16")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun przypiszkarty(lewel: Int) {
        if (lewel <= 3) {
            K1 = findViewById(R.id.L1P1)
            K2 = findViewById(R.id.L1P2)
            K3 = findViewById(R.id.L1P3)
            K4 = findViewById(R.id.L1P4)
            K5 = findViewById(R.id.L1P5)
            K6 = findViewById(R.id.L1P6)
        }
        if (lewel > 3) {
            K1 = findViewById(R.id.L4P1)
            K2 = findViewById(R.id.L4P2)
            K3 = findViewById(R.id.L4P3)
            K4 = findViewById(R.id.L4P4)
            K5 = findViewById(R.id.L4P5)
            K6 = findViewById(R.id.L4P6)
            K7 = findViewById(R.id.L4P7)
            K8 = findViewById(R.id.L4P8)
            K9 = findViewById(R.id.L4P9)
        }
        if (lewel > 8) {
            K10 = findViewById(R.id.L4P10)
            K11 = findViewById(R.id.L4P11)
            K12 = findViewById(R.id.L4P12)
        }
        if (lewel > 13) {
            K13 = findViewById(R.id.L4P13)
            K14 = findViewById(R.id.L4P14)
            K15 = findViewById(R.id.L4P15)
            K16 = findViewById(R.id.L4P16)
        }
    }

    fun Odwruckarte(karta: ImageButton?, kolor: Int) {
        if (kolor == 1) {
            karta!!.background = czerwona
        }
        if (kolor == 2) {
            karta!!.background = niebieska
        }
        if (kolor == 3) {
            karta!!.background = zielona
        }
        if (kolor == 4) {
            karta!!.background = zulta
        }
        if (kolor == 5) {
            karta!!.background = pomaranczowa
        }
        if (kolor == 6) {
            karta!!.background = ruzowa
        }
    }


    fun losowaniekolorukart(lewel: Int) {
        Kk1 = losujkolor(lewel)
        Kk2 = losujkolor(lewel)
        Kk3 = losujkolor(lewel)
        Kk4 = losujkolor(lewel)
        Kk5 = losujkolor(lewel)
        Kk6 = losujkolor(lewel)
        Listakolorow!!.add(Kk1!!)
        Listakolorow!!.add(Kk2!!)
        Listakolorow!!.add(Kk3!!)
        Listakolorow!!.add(Kk4!!)
        Listakolorow!!.add(Kk5!!)
        Listakolorow!!.add(Kk6!!)
        if (lewel > 3) {
            Kk7 = losujkolor(lewel)
            Kk8 = losujkolor(lewel)
            Kk9 = losujkolor(lewel)
            Listakolorow!!.add(Kk7!!)
            Listakolorow!!.add(Kk8!!)
            Listakolorow!!.add(Kk9!!)
        }
        if (lewel > 8) {
            Kk10 = losujkolor(lewel)
            Kk11 = losujkolor(lewel)
            Kk12 = losujkolor(lewel)
            Listakolorow!!.add(Kk10!!)
            Listakolorow!!.add(Kk11!!)
            Listakolorow!!.add(Kk12!!)
        }
        if (lewel > 13) {
            Kk13 = losujkolor(lewel)
            Kk14 = losujkolor(lewel)
            Kk15 = losujkolor(lewel)
            Kk16 = losujkolor(lewel)
            Listakolorow!!.add(Kk13!!)
            Listakolorow!!.add(Kk14!!)
            Listakolorow!!.add(Kk15!!)
            Listakolorow!!.add(Kk16!!)
        }
    }

    fun losujkolor(lewel: Int): Int {
        val r = Random()
        var los = 0
        if (lewel == 1) {
            los = r.nextInt(2) + 1
        }
        if (lewel == 2) {
            los = r.nextInt(3) + 1
        }
        if (lewel == 3) {
            los = r.nextInt(4) + 1
        }
        if (lewel == 4) {
            los = r.nextInt(2) + 1
        }
        if (lewel == 5) {
            los = r.nextInt(3) + 1
        }
        if (lewel == 6) {
            los = r.nextInt(4) + 1
        }
        if (lewel == 7) {
            los = r.nextInt(5) + 1
        }
        if (lewel == 8) {
            los = r.nextInt(6) + 1
        }
        if (lewel == 9) {
            los = r.nextInt(2) + 1
        }
        if (lewel == 10) {
            los = r.nextInt(3) + 1
        }
        if (lewel == 11) {
            los = r.nextInt(4) + 1
        }
        if (lewel == 12) {
            los = r.nextInt(5) + 1
        }
        if (lewel == 13) {
            los = r.nextInt(6) + 1
        }
        ///lewel 14+
        if (lewel == 14) {
            los = r.nextInt(2) + 1
        }
        if (lewel == 15) {
            los = r.nextInt(3) + 1
        }
        if (lewel == 16) {
            los = r.nextInt(4) + 1
        }
        if (lewel == 17) {
            los = r.nextInt(5) + 1
        }
        if (lewel == 18) {
            los = r.nextInt(6) + 1
        }
        //
        return los
    }

    fun relosuj() {
        var Tk1: Int
        var Tk2: Int
        var Tk3: Int
        var Tk4: Int
        var Tk5: Int
        var Tk6: Int
        var Tk7: Int
        var Tk8: Int
        var Tk9: Int

        val psl: MutableList<Int> = ArrayList()
        var pow = 0
        var cykle = 0

        var i = 0
        while (i < Listakolorow!!.size) {
            val r = Random()
            val los = r.nextInt(Listakolorow!!.size)
            Log.d("LOS", "los:$los")
            if (!psl.contains(los)) {
                if (i == 0) {
                    Kk1 = Listakolorow!![los]
                }
                if (i == 1) {
                    Kk2 = Listakolorow!![los]
                }
                if (i == 2) {
                    Kk3 = Listakolorow!![los]
                }
                if (i == 3) {
                    Kk4 = Listakolorow!![los]
                }
                if (i == 4) {
                    Kk5 = Listakolorow!![los]
                }
                if (i == 5) {
                    Kk6 = Listakolorow!![los]
                }
                if (i == 6) {
                    Kk7 = Listakolorow!![los]
                }
                if (i == 7) {
                    Kk8 = Listakolorow!![los]
                }
                if (i == 8) {
                    Kk9 = Listakolorow!![los]
                }
                if (i == 9) {
                    Kk10 = Listakolorow!![los]
                }
                if (i == 10) {
                    Kk11 = Listakolorow!![los]
                }
                if (i == 11) {
                    Kk12 = Listakolorow!![los]
                }
                if (i == 12) {
                    Kk13 = Listakolorow!![los]
                }
                if (i == 13) {
                    Kk14 = Listakolorow!![los]
                }
                if (i == 14) {
                    Kk15 = Listakolorow!![los]
                }
                if (i == 15) {
                    Kk16 = Listakolorow!![los]
                }
                Log.d("I", "i:$i")
                psl.add(los)
                cykle++
            } else {
                i--
                pow++
            }
            i++
        }


        //Powiadomienie("powturka:" + pow +"cyk"+cykle+"los");
    }

    fun ZapiszPref(lewelunlok: Int) {
        val editor = applicationContext.getSharedPreferences("Swinka", MODE_PRIVATE).edit()
        editor.putInt("lewelunlok", lewelunlok)
        editor.apply()
    }


    fun Powiadomienie(wiadomosc: String?) {
        Snackbar.make(
            this.findViewById(android.R.id.content),
            wiadomosc!!,
            Snackbar.LENGTH_SHORT
        )
            .setDuration(5000).setAction("Action", null).show()
    }

    private fun signInSilently() {
        val signInOptions = GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (GoogleSignIn.hasPermissions(account, *signInOptions.scopeArray)) {
            // Already signed in.
            // The signed in account is stored in the 'account' variable.
            val signedInAccount = account
        } else {
            // Haven't been signed-in before. Try the silent sign-in first.
            val signInClient = GoogleSignIn.getClient(this, signInOptions)
            signInClient
                .silentSignIn()
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        // The signed in account is stored in the task's result.
                        val signedInAccount = task.result
                    } else {
                        // Player will need to sign-in explicitly using via UI.
                        // See [sign-in best practices](http://developers.google.com/games/services/checklist) for guidance on how and when to implement Interactive Sign-in,
                        // and [Performing Interactive Sign-in](http://developers.google.com/games/services/android/signin#performing_interactive_sign-in) for details on how to implement
                        // Interactive Sign-in.
                    }
                }
        }
    }


    /** Called when leaving the activity  */
    public override fun onPause() {
        if (adView != null) {
            adView!!.pause()
        }
        super.onPause()
    }


    /** Called before the activity is destroyed  */
    public override fun onDestroy() {
        if (adView != null) {
            adView!!.destroy()
        }
        super.onDestroy()
    }

    private fun loadBanner() {
        // Create an ad request.
        adView = AdView(this)
        adView!!.adUnitId = AD_UNIT_ID
        adContainerView!!.removeAllViews()
        adContainerView!!.addView(adView)

        val adSize = adSize
        adView!!.setAdSize(adSize)

        val adRequest = AdRequest.Builder().build()

        // Start loading the ad in the background.
        adView!!.loadAd(adRequest)
    }


    private val adSize: AdSize
        get() {
            // Step 2 - Determine the screen width (less decorations) to use for the ad width.
            val display = windowManager.defaultDisplay
            val outMetrics = DisplayMetrics()
            display.getMetrics(outMetrics)

            val widthPixels = outMetrics.widthPixels.toFloat()
            val density = outMetrics.density

            val adWidth = (widthPixels / density).toInt()

            // Step 3 - Get adaptive ad size and return for setting on the ad view.
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth)
        }


    companion object {
        private const val AD_UNIT_ID = "ca-app-pub-4834003578511022/1507969669"
    }
}

