package com.koltech.swinka

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.games.Games
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val mAdView: AdView? = null

    private var adView: AdView? = null
    private var adContainerView: FrameLayout? = null
    var signInButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //signInButton = findViewById(R.id.Sing_in);
        MobileAds.initialize(this) { }


        adContainerView = findViewById(R.id.adconMenu)

        // Since we're loading the banner based on the adContainerView size, we need to wait until this
        // view is laid out before we can get the width.
        (adContainerView as? FrameLayout)?.post(Runnable { loadBanner() })
    }


    // if (view.getId() == R.id.Sing_in) {
    // start the asynchronous sign in flow
    fun LewelList(v: View?) {
        val intent = Intent(this@MainActivity, LewelList::class.java)
        startActivity(intent)
    }

    fun jakgrac(v: View?) {
        val intent = Intent(this@MainActivity, jak_grac::class.java)
        startActivity(intent)
    }

    fun Castom(v: View?) {
        Powiadomienie("Feature available soon.")
        //setContentView(R.layout.leweljeden);
    }

    fun Exit(v: View?) {
        ExitEX()
    }

    fun ExitEX() {
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        val mView = layoutInflater.inflate(R.layout.exit_question, null)
        val tak = mView.findViewById<View>(R.id.exit_but_tak) as Button
        val nie = mView.findViewById<View>(R.id.exit_but_nie) as Button

        mBuilder.setView(mView)
        val dialog = mBuilder.create()
        dialog.show()

        tak.setOnClickListener {
            dialog.cancel()
            finish()
        }

        nie.setOnClickListener { dialog.cancel() }
    }

    fun Singin(v: View?) {
        startSignInIntent()
    }

    fun Achievements(v: View?) {
        try {
            Games.getAchievementsClient(this, GoogleSignIn.getLastSignedInAccount(this)!!)
                .achievementsIntent
                .addOnSuccessListener { intent ->
                    startActivityForResult(
                        intent!!,
                        RC_ACHIEVEMENT_UI
                    )
                }
        } catch (e: Exception) {
            val mBuilder = AlertDialog.Builder(this@MainActivity)
            val mView = layoutInflater.inflate(R.layout.google_main, null)
            mBuilder.setView(mView)
            val ok = mView.findViewById<View>(R.id.Sing_in_ok) as Button
            val dialog = mBuilder.create()
            dialog.show()

            ok.setOnClickListener { dialog.cancel() }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        ExitEX()
    }


    fun Powiadomienie(wiadomosc: String?) {
        Snackbar.make(
            this.findViewById(android.R.id.content),
            wiadomosc!!,
            Snackbar.LENGTH_SHORT
        )
            .setDuration(20000).setAction("Action", null).show()
    }


    fun startSignInIntent() {
        val signInClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
        )
        val intent = signInClient.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!)
            if (result!!.isSuccess) {
                // The signed in account is stored in the result.
                val signedInAccount = result.signInAccount
            } else {
                var message = result.status.statusMessage
                if (message == null || message.isEmpty()) {
                    message = "For some reason, we could not connect to google services."
                }
                AlertDialog.Builder(this).setMessage(message)
                    .setNeutralButton(android.R.string.ok, null).show()
            }
        }
    }

    private fun signOut() {
        val signInClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
        )
        signInClient.signOut().addOnCompleteListener(
            this
        ) {
            // at this point, the user is signed out.
        }
    }


    override fun onResume() {
        super.onResume()
        if (adView != null) {
            adView!!.resume()
        }
        signInSilently()
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
        private const val AD_UNIT_ID = "ca-app-pub-4834003578511022/5303744446"

        private const val RC_ACHIEVEMENT_UI = 9003
        private const val RC_SIGN_IN = 9001
    }
}
