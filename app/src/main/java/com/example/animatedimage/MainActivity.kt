package com.example.animatedimage

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val gifIds = listOf(
        R.drawable.cat,
        R.drawable.rainbow_animated)
    var pointer = 0
    fun incrementPointer(){
        pointer++
        if (pointer >= gifIds.size){
            pointer =0
        }
    }
    fun decremenetPointer(){
        pointer--
        if (pointer < 0){
            pointer = gifIds.size -1
        }
    }


    val handIds = listOf(
        R.drawable.avd_hand_to_pet,
        R.drawable.avd_pet_to_hand)
    var point = 0
    fun incrementPoint(){
        point++
        if (point >= handIds.size){
            point =0
        }
    }
    fun decremenetPoint(){
        point--
        if (point < 0){
            point = handIds.size -1
        }
    }



    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_play.setOnClickListener { view ->
            when (pointer) {
                0 -> animateGif(gifIds[pointer], animated_image)
                1 -> animateAnimationDrawable((gifIds[pointer]), animated_image)
            }
            incrementPoint()
            when (point) {
                0 -> animateVectorDrawable(handIds[point], button_play)
                1 -> animateVectorDrawable1(handIds[point], button_play)
            }
        }

        button_next.setOnClickListener {
            incrementPointer()
            animated_image.setImageDrawable(
                ContextCompat.getDrawable(this, gifIds[pointer])
            )
        }

        button_pause.setOnClickListener {
            decremenetPointer()
            animated_image.setImageDrawable(
                ContextCompat.getDrawable(this, gifIds[pointer])
            )
        }
    }

        private fun animateVectorDrawable(id: Int, view: ImageView){
            val animatedVectorDrawable = ContextCompat.getDrawable(this, R.drawable.avd_hand_to_pet)
            view.setImageDrawable(animatedVectorDrawable)
            (animatedVectorDrawable as Animatable).start()
        }

        private fun animateVectorDrawable1(id: Int, view: ImageView){
        val animatedVectorDrawable = ContextCompat.getDrawable(this, R.drawable.avd_pet_to_hand)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }

        private fun animateGif(id: Int, view: ImageView) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val myCat = ImageDecoder.decodeDrawable(
                    ImageDecoder.createSource(
                        resources, id
                    )
                )
                animated_image.setImageDrawable(myCat)
                (myCat as AnimatedImageDrawable).start()
            }
        }

        private fun animateAnimationDrawable(id: Int, view: ImageView){
            val myRainbow = ContextCompat.getDrawable(this, id)
            view.setImageDrawable(myRainbow)
            (myRainbow as AnimationDrawable).start()
        }
}
