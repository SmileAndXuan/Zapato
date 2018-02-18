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

class tap_activity : AppCompatActivity() {

    //var ref = FirebaseDatabase.getInstance().getReference("users")

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

        // Firebase record call as current google logged in user
        var fba : FirebaseUser? = FirebaseAuth.getInstance().getCurrentUser()
        var db : DatabaseReference? = FirebaseDatabase.getInstance().reference
        //db!!.child("users").child(fba!!.uid).child("name").setValue("Bruh==James")
        //db!!.child("users").child(fba!!.uid).child("shipping_address").setValue("addresses")
        //db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses1").setValue("home")
        //db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses1").child("home").setValue("Bruh's room")
        //db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses2").setValue("dorm")
        //db!!.child("users").child(fba!!.uid).child("shipping_address").child("addresses3").setValue("man cave in the mountain")
        //db!!.child("users").child(fba!!.uid).child("shipping_date").setValue("send it now duh")
        //db!!.child("users").child(fba!!.uid).child("payment").setValue("send it now duh")

        db!!.child("users").child(fba!!.uid).child("1name").setValue("myvalue")
        db!!.child("users").child(fba!!.uid).child("2email_address").setValue("myvalue")
        db!!.child("users").child(fba!!.uid).child("3phone_number").setValue("myvalue")
        db!!.child("users").child(fba!!.uid).child("4shipping_address").child("location1").setValue("place")
        db!!.child("users").child(fba!!.uid).child("4shipping_address").child("location2").setValue("place")
        db!!.child("users").child(fba!!.uid).child("4shipping_address").child("location3").setValue("place")
        db!!.child("users").child(fba!!.uid).child("4shipping_address").child("location4").setValue("place")
        db!!.child("users").child(fba!!.uid).child("5billing_address").child("location1").setValue("place")
        db!!.child("users").child(fba!!.uid).child("5billing_address").child("location2").setValue("place")
        db!!.child("users").child(fba!!.uid).child("5billing_address").child("location3").setValue("place")
        db!!.child("users").child(fba!!.uid).child("5billing_address").child("location4").setValue("place")
        db!!.child("users").child(fba!!.uid).child("6buy_history").child("buy1").setValue("item_bought")
        db!!.child("users").child(fba!!.uid).child("6buy_history").child("buy2").setValue("item_bought")
        db!!.child("users").child(fba!!.uid).child("6buy_history").child("buy3").setValue("item_bought")
        db!!.child("users").child(fba!!.uid).child("6buy_history").child("buy4").setValue("item_bought")
        db!!.child("users").child(fba!!.uid).child("7sell_history").child("sell1").setValue("item_sold")
        db!!.child("users").child(fba!!.uid).child("7sell_history").child("sell2").setValue("item_sold")
        db!!.child("users").child(fba!!.uid).child("7sell_history").child("sell3").setValue("item_sold")
        db!!.child("users").child(fba!!.uid).child("7sell_history").child("sell4").setValue("item_sold")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("From").setValue("message transmitter")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("To").setValue("message receipient(s)")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("Subject").setValue("message to transmit title")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("Body").setValue("message to transmit body")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("stored").setValue("inbox")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("starred").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("important").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival1").child("ismarkedjunk").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("From").setValue("message transmitter")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("To").setValue("message receipient(s)")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("Subject").setValue("message to transmit title")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("Body").setValue("message to transmit body")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("stored").setValue("inbox")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("starred").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("important").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival2").child("ismarkedjunk").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("From").setValue("message transmitter")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("To").setValue("message receipient(s)")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("Subject").setValue("message to transmit title")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("Body").setValue("message to transmit body")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("stored").setValue("inbox")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("starred").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("important").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival3").child("ismarkedjunk").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("From").setValue("message transmitter")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("To").setValue("message receipient(s)")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("Subject").setValue("message to transmit title")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("Body").setValue("message to transmit body")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("stored").setValue("inbox")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("starred").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("important").setValue("f")
        db!!.child("users").child(fba!!.uid).child("8conversation").child("emailtype").child("timeofarrival4").child("ismarkedjunk").setValue("f")
        //db!!.child("users").child(fba!!.uid).child("8conversation").child("chattype").child("toperson1").child("received1").setValue("r")
        //db!!.child("users").child(fba!!.uid).child("8conversation").child("chattype").child("toperson1").child("received2").setValue("r")
        //db!!.child("users").child(fba!!.uid).child("8conversation").child("chattype").child("toperson2").child("received3").setValue("r")
        //db!!.child("users").child(fba!!.uid).child("8conversation").child("chattype").child("toperson2").child("sent1").setValue("s")
        //db!!.child("users").child(fba!!.uid).child("8conversation").child("chattype").child("toperson3").child("sent2").setValue("s")
       // db!!.child("users").child(fba!!.uid).child("8conversation").child("chattype").child("toperson3").child("sent3").setValue("s")
        //val key = ref.push().key
        //ref.child(key).setValue("uniquetest")

        //tab_host.setOnClickListener { UserCustomMethod() }
    }

    fun UserCustomMethod() {
        val intent2 = Intent(this, tap_activity2::class.java)
        //intent.putExtra("datatopasstonextactivity", user.datatopasstonextactivity)
        startActivity(intent2)
    }
}
