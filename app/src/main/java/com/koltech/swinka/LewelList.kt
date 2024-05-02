package com.koltech.swinka

import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.games.Games
import com.koltech.swinka.GameLI

class LewelList : AppCompatActivity() {
    var B1: Button? = null
    var B2: Button? = null
    var B3: Button? = null
    var B4: Button? = null
    var B5: Button? = null
    var B6: Button? = null
    var B7: Button? = null
    var B8: Button? = null
    var B9: Button? = null
    var B10: Button? = null
    var B11: Button? = null
    var B12: Button? = null
    var B13: Button? = null
    var B14: Button? = null
    var B15: Button? = null
    var B16: Button? = null
    var B17: Button? = null
    var B18: Button? = null
    var B19: Button? = null
    var B20: Button? = null
    var chek: Drawable? = null
    var lewel1: Int = 0
    var lewel2: Int = 0
    var lewel3: Int = 0
    var lewel4: Int = 0
    var lewel5: Int = 0
    var lewel6: Int = 0
    var lewel7: Int = 0
    var lewel8: Int = 0
    var lewel9: Int = 0
    var lewel10: Int = 0
    var lewel11: Int = 0
    var lewel12: Int = 0
    var lewel13: Int = 0
    var lewel14: Int = 0
    var lewel15: Int = 0
    var lewel16: Int = 0
    var lewel17: Int = 0
    var lewel18: Int = 0
    var lewel19: Int = 0
    var lewel20: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_listaleweli)

        Wczytajprefy()

        B1 = findViewById(R.id.b1)
        B2 = findViewById(R.id.b2)
        B3 = findViewById(R.id.b3)
        B4 = findViewById(R.id.b4)
        B5 = findViewById(R.id.b5)
        B6 = findViewById(R.id.b6)
        B7 = findViewById(R.id.b7)
        B8 = findViewById(R.id.b8)
        B9 = findViewById(R.id.b9)
        B10 = findViewById(R.id.b10)
        B11 = findViewById(R.id.b11)
        B12 = findViewById(R.id.b12)
        B13 = findViewById(R.id.b13)
        B14 = findViewById(R.id.b14)
        B15 = findViewById(R.id.b15)
        B16 = findViewById(R.id.b16)
        B17 = findViewById(R.id.b17)
        B18 = findViewById(R.id.b18)


        spr()
        achivmentupd()



        B1!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LewelList, GameLI::class.java)
            intent.putExtra("Lewel", "1")
            startActivity(intent)
        })


        B2!!.setOnClickListener(View.OnClickListener {
            if (lewel1 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "2")
                startActivity(intent)
            } else powiadomienie()
        })

        B3!!.setOnClickListener(View.OnClickListener {
            if (lewel2 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "3")
                startActivity(intent)
            } else powiadomienie()
        })

        B4!!.setOnClickListener(View.OnClickListener {
            if (lewel3 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "4")
                startActivity(intent)
            } else powiadomienie()
        })

        B5!!.setOnClickListener(View.OnClickListener {
            if (lewel4 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "5")
                startActivity(intent)
            } else powiadomienie()
        })

        B6!!.setOnClickListener(View.OnClickListener {
            if (lewel5 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "6")
                startActivity(intent)
            } else powiadomienie()
        })

        B7!!.setOnClickListener(View.OnClickListener {
            if (lewel6 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "7")
                startActivity(intent)
            } else powiadomienie()
        })

        B8!!.setOnClickListener(View.OnClickListener {
            if (lewel7 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "8")
                startActivity(intent)
            } else powiadomienie()
        })

        B9!!.setOnClickListener(View.OnClickListener {
            if (lewel8 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "9")
                startActivity(intent)
            } else powiadomienie()
        })

        B10!!.setOnClickListener(View.OnClickListener {
            if (lewel9 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "10")
                startActivity(intent)
            } else powiadomienie()
        })

        B11!!.setOnClickListener(View.OnClickListener {
            if (lewel10 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "11")
                startActivity(intent)
            } else powiadomienie()
        })

        B12!!.setOnClickListener(View.OnClickListener {
            if (lewel11 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "12")
                startActivity(intent)
            } else powiadomienie()
        })

        B13!!.setOnClickListener(View.OnClickListener {
            if (lewel12 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "13")
                startActivity(intent)
            } else powiadomienie()
        })

        B14!!.setOnClickListener(View.OnClickListener {
            if (lewel13 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "14")
                startActivity(intent)
            } else powiadomienie()
        })
        B15!!.setOnClickListener(View.OnClickListener {
            if (lewel14 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "15")
                startActivity(intent)
            } else powiadomienie()
        })
        B16!!.setOnClickListener(View.OnClickListener {
            if (lewel15 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "16")
                startActivity(intent)
            } else powiadomienie()
        })
        B17!!.setOnClickListener(View.OnClickListener {
            if (lewel16 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "17")
                startActivity(intent)
            } else powiadomienie()
        })
        B18!!.setOnClickListener(View.OnClickListener {
            if (lewel17 == 1) {
                val intent = Intent(this@LewelList, GameLI::class.java)
                intent.putExtra("Lewel", "18")
                startActivity(intent)
            } else powiadomienie()
        })
    }

    public override fun onResume() {
        super.onResume()

        Wczytajprefy()

        spr()
        achivmentupd()
    }

    fun spr() {
        val res = resources
        chek = ResourcesCompat.getDrawable(res, R.drawable.cheks, null)

        if (lewel1 == 1) {
            B1!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel2 == 1) {
            B2!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel3 == 1) {
            B3!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel4 == 1) {
            B4!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel5 == 1) {
            B5!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel6 == 1) {
            B6!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel7 == 1) {
            B7!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel8 == 1) {
            B8!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel9 == 1) {
            B9!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel10 == 1) {
            B10!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel11 == 1) {
            B11!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel12 == 1) {
            B12!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel13 == 1) {
            B13!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel14 == 1) {
            B14!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }

        if (lewel15 == 1) {
            B15!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel16 == 1) {
            B16!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel17 == 1) {
            B17!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
        if (lewel18 == 1) {
            B18!!.setCompoundDrawablesWithIntrinsicBounds(
                null,  // Drawable left
                null,  // Drawable top
                chek,  // Drawable right
                null // Drawable bottom
            )
        }
    }

    fun Wczytajprefy() {
        try {
            val preferences = getSharedPreferences("Swinka", MODE_PRIVATE)
            lewel1 = preferences.getInt("lewel1", 0)
            lewel2 = preferences.getInt("lewel2", 0)
            lewel3 = preferences.getInt("lewel3", 0)
            lewel4 = preferences.getInt("lewel4", 0)
            lewel5 = preferences.getInt("lewel5", 0)
            lewel6 = preferences.getInt("lewel6", 0)
            lewel7 = preferences.getInt("lewel7", 0)
            lewel8 = preferences.getInt("lewel8", 0)

            lewel9 = preferences.getInt("lewel9", 0)
            lewel10 = preferences.getInt("lewel10", 0)
            lewel11 = preferences.getInt("lewel11", 0)
            lewel12 = preferences.getInt("lewel12", 0)
            lewel13 = preferences.getInt("lewel13", 0)
            lewel14 = preferences.getInt("lewel14", 0)

            lewel15 = preferences.getInt("lewel15", 0)
            lewel16 = preferences.getInt("lewel16", 0)
            lewel17 = preferences.getInt("lewel17", 0)
            lewel18 = preferences.getInt("lewel18", 0)
            lewel19 = preferences.getInt("lewel19", 0)
            lewel20 = preferences.getInt("lewel20", 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun ZapiszPref() {
        val editorpref = applicationContext.getSharedPreferences("Swinka", MODE_PRIVATE).edit()
        editorpref.putInt("lewel1", lewel1)
        editorpref.apply()
    }

    fun achivmentupd() {
        try {
            signInSilently()






            if (lewel1 == 1) {
                Achivment(getString(R.string.achievement_level_1))
            }
            if (lewel2 == 1) {
                Achivment(getString(R.string.achievement_level_2))
            }
            if (lewel3 == 1) {
                Achivment(getString(R.string.achievement_level_3))
            }
            if (lewel4 == 1) {
                Achivment(getString(R.string.achievement_level_4))
            }
            if (lewel5 == 1) {
                Achivment(getString(R.string.achievement_level_5))
            }
            if (lewel6 == 1) {
                Achivment(getString(R.string.achievement_level_6))
            }
            if (lewel7 == 1) {
                Achivment(getString(R.string.achievement_level_7))
            }
            if (lewel8 == 1) {
                Achivment(getString(R.string.achievement_level_8))
            }
            if (lewel9 == 1) {
                Achivment(getString(R.string.achievement_level_9))
            }
            if (lewel10 == 1) {
                Achivment(getString(R.string.achievement_level_10))
            }
            if (lewel11 == 1) {
                Achivment(getString(R.string.achievement_level_11))
            }
            if (lewel12 == 1) {
                Achivment(getString(R.string.achievement_level_12))
            }
            if (lewel13 == 1) {
                Achivment(getString(R.string.achievement_level_13))
            }
            if (lewel14 == 1) {
                Achivment(getString(R.string.achievement_level_14))
            }
            if (lewel15 == 1) {
                Achivment(getString(R.string.achievement_level_15))
            }
            if (lewel16 == 1) {
                Achivment(getString(R.string.achievement_level_16))
            }
            if (lewel17 == 1) {
                Achivment(getString(R.string.achievement_level_17))
            }
            if (lewel18 == 1) {
                Achivment(getString(R.string.achievement_level_18))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun Achivment(Acz: String?) {
        Games.getAchievementsClient(this, GoogleSignIn.getLastSignedInAccount(this)!!)
            .unlock(Acz!!)
    }


    private fun signInSilently() {
        val signInOptions = GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (GoogleSignIn.hasPermissions(account, *signInOptions.scopeArray)) {
            // Already signed in.
            // The signed in account is stored in the 'account' variable.
            val signedInAccount = account

            val gamesClient = Games.getGamesClient(this@LewelList, signedInAccount!!)
            gamesClient.setViewForPopups(findViewById(R.id.container_pop_up))
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

    fun powiadomienie() {
        val mBuilder = AlertDialog.Builder(this@LewelList)
        val mView = layoutInflater.inflate(R.layout.powiadomienie_lewel, null)
        val ok = mView.findViewById<View>(R.id.powok) as Button

        mBuilder.setView(mView)
        val dialog = mBuilder.create()
        dialog.show()

        ok.setOnClickListener { dialog.cancel() }
    }
}
