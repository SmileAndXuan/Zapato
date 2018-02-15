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
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class tap_activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        // Get the currently signed-in user
        var user : FirebaseUser? = FirebaseAuth.getInstance().getCurrentUser()
        if (user != null) {
            // User is signed in
        } else {
            // No user is signed in
        }

        // Firebase record call as current google logged in user
        var fba : FirebaseUser? = FirebaseAuth.getInstance().getCurrentUser()
        var db : DatabaseReference? = FirebaseDatabase.getInstance().reference
        db!!.child("users").child(fba!!.uid).child("email").setValue("jamesajfreedompop1@gmail.com")
        db!!.child("users").child(fba!!.uid).child("name").setValue("James")
        db!!.child("users").child(fba!!.uid).child("shipping_address").setValue("addresses")
        db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses1").setValue("home")
        db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses1").child("home").setValue("James's room")
        db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses2").setValue("school")
        db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses3").setValue("lab")
        db!!.child("users").child(fba!!.uid).child("shipping_date").setValue("pretty soon")

        //tab_host.setOnClickListener { UserCustomMethod() }
    }

    fun UserCustomMethod() {
        val intent2 = Intent(this, MainActivity::class.java)
        //intent.putExtra("datatopasstonextactivity", user.datatopasstonextactivity)
        startActivity(intent2)
    }
}
