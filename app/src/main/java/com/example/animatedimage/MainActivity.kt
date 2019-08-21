package com.example.animatedimage

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_next.setOnClickListener {
            animateGif()
        }

        button_pause.setOnClickListener {
            animateAnimationDrawable()
        }
    }
        private fun animateGif() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val myCat = ImageDecoder.decodeDrawable(
                    ImageDecoder.createSource(
                        resources, R.drawable.cat
                    )
                )
                animated_image.setImageDrawable(myCat)
                (myCat as AnimatedImageDrawable).start()
            }
        }

        private fun animateAnimationDrawable(){
            val myRainbow = ContextCompat.getDrawable(this, R.drawable.rainbow_animted)
            animated_image.setImageDrawable(myRainbow)
            (myRainbow as AnimationDrawable).start()
        }

}
