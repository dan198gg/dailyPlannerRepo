package com.example.dailyplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class LogoActivity : AppCompatActivity(),Animation.AnimationListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        var img=findViewById<ImageView>(R.id.imageLogo)
        var animIn=AnimationUtils.loadAnimation(this,R.anim.fading_in)
        animIn.setAnimationListener(this)
        img.startAnimation(animIn)

    }

    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        var intent1=Intent(this,MainActivity::class.java)
        startActivity(intent1)
        finish()
    }

    override fun onAnimationRepeat(animation: Animation?) {
        TODO("Not yet implemented")
    }
}