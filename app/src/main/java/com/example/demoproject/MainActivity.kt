package com.example.demoproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.moengage.core.MoEngage
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.inapp.MoEInAppHelper
import com.moengage.pushbase.MoEPushHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MoEPushHelper.getInstance().requestPushPermission(this)

        val signupbutton = findViewById<View>(R.id.signupbutton) as MaterialButton

        signupbutton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)

            val username = findViewById<TextView>(R.id.username)
            MoEAnalyticsHelper.setUniqueId(this,username.text.toString())

            val firstname = findViewById<TextView>(R.id.firstname)
            MoEAnalyticsHelper.setFirstName(this,firstname.text.toString())

            val lastname = findViewById<TextView>(R.id.lastname)
            MoEAnalyticsHelper.setLastName(this,lastname.text.toString())

            val phone = findViewById<TextView>(R.id.phonenumber)
            MoEAnalyticsHelper.setMobileNumber(this, phone.text.toString())

            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }
}