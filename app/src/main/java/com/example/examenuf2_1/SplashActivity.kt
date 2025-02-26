package com.example.examenuf2_1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.examenuf2_1.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ball.setOnClickListener {
            val animSet = AnimationSet(true)
            animSet.isFillEnabled = true

            val animation1 = AnimationUtils.loadAnimation(applicationContext, R.anim.esquerra_a_dreta_engrandir)
            val animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.amunt_avall)

            animation2.startOffset = animation1.duration

            animSet.addAnimation(animation1)
            animSet.addAnimation(animation2)

            animSet.fillAfter = true
            binding.ball.startAnimation(animSet)

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                // Time in milliseconds
            }, animation2.duration + animation2.startOffset)
        }




    }
}