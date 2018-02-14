package com.zapato.zapato

/**
 * Created by adrian on 2/12/18.
 */

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_tab.*
import com.google.firebase.internal.FirebaseAppHelper.getUid
//import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper.getProviderId
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


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
/*
        Log.d("FuckYouuuuuuuu one", "" + FirebaseAuth.getInstance().getCurrentUser())
        Log.d("FuckYouuuuuuuu two", "" + FirebaseAuth.getInstance().getCurrentUser())

        var fba : FirebaseUser? = FirebaseAuth.getInstance().getCurrentUser()
        Log.d("FuckYouuuuuuuu three", fba!!.displayName)
        Log.d("FuckYouuuuuuuu four", fba!!.email)
        Log.d("FuckYouuuuuuuu five", fba!!.uid)

        var fbb : FirebaseUser? = FirebaseAuth.getInstance().currentUser
*/

        //FirebaseDatabase.getInstance().getReference().child("name").setValue("aaa")
        //var db : DatabaseReference? = null
        //db = FirebaseDatabase.getInstance().reference
        //FirebaseDatabase.getInstance().getReference("name")
        //db!!.child("users").child(fba!!.uid).child("name").setValue("cool, bro")
        //FirebaseDatabase.getInstance().getReference().child("name").setValue("hoiooio")
        //Log.d("FU5", FirebaseDatabase.getInstance().getReference().child("name").setValue("hoiooio")

        var fba : FirebaseUser? = FirebaseAuth.getInstance().getCurrentUser()
        var db : DatabaseReference? = FirebaseDatabase.getInstance().reference
        db!!.child("users").child(fba!!.uid).child("name").setValue("cool, bro")


/*
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            for (profile in user.providerData) {
                // Id of the provider (ex: google.com)
                val providerId = profile.providerId

                // UID specific to the provider
                val uid = profile.uid

                // Name, email address, and profile photo Url
                val name = profile.displayName
                val email = profile.email
                val photoUrl = profile.photoUrl
            }
        }
*/

        //tab_host.setOnClickListener { UserCustomMethod() }
    }

    fun UserCustomMethod() {
        val intent2 = Intent(this, MainActivity::class.java)
        //intent.putExtra("username", user.name)
        startActivity(intent2)
    }

    //AuthStateListener authlistener
    /*
    authlistener = new FirebaseAuth.AuthStateListener() {
        //@Override
        fun onAuthStateChanged(firebaseAuth : FirebaseAuth ) {
            FirebaseUser user = firebaseAuth.getCurrentUser()
            if (user != null) {
                // User is signed in

            } else {
                // User is signed out
            }
        }
    };
    FirebaseAuth.getInstance().addAuthStateListener(authListener)
    */

    fun getFirebaseUser() : FirebaseUser? {
        Log.d("testtest", "" + FirebaseAuth.getInstance().getCurrentUser())
        return null
    }
}
