package com.zapato.zapato

/**
 * Created by adrian on 2/12/18.
 */

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_tab.*

class tap_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_logindebug)
        setContentView(R.layout.activity_tab)

        // setup tap host
        tab_host.setup()

        // setup tabs
        var spec = tab_host.newTabSpec("Tab One")
        spec.setContent(R.id.tab_one)
        spec.setIndicator("Tab One")
        tab_host.addTab(spec)

        spec = tab_host.newTabSpec("Tab Two")
        spec.setContent(R.id.tab_two)
        spec.setIndicator("Tab Two")
        tab_host.addTab(spec)

        spec = tab_host.newTabSpec("Tab Three")
        spec.setContent(R.id.tab_three)
        spec.setIndicator("Tab Three")
        tab_host.addTab(spec)


        // receive data from MainActivity
        var username = intent.getStringExtra("username")

        // Setting up name into TextView.
        username_textview.text = "Hi " + username

        var prefs: Prefs? = null
        prefs = Prefs(this)
        Log.d("Recall my data", "" + prefs!!.bgColor)
        username_textview.text = "Hi " + username + prefs!!.bgColor



        ///////////////////////////////////////////////////
        var pref = getApplicationContext().getSharedPreferences("MyPref", 0) // 0 - for private mode
        var editor = pref.edit()
        // returns stored preference value
        // If value is not present return second param value - In this case null
        pref.getString("key_name", null); // getting String
        //pref.getInt("key_name", null); // getting Integer
        //pref.getFloat("key_name", null); // getting Float
        //pref.getLong("key_name", null); // getting Long
        //pref.getBoolean("key_name", null); // getting boolean
        //username_textview.text = "Hi " + username + pref.getString("key_name", null)
        ///////////////////////////////////////////////////

        tab_host.setOnClickListener { UserCustomMethod() }
    }

    fun UserCustomMethod() {
        val intent2 = Intent(this, MainActivity::class.java)
        //intent.putExtra("username", user.name)
        startActivity(intent2)
    }

}
