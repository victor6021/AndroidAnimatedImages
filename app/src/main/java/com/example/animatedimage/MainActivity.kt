package com.example.animatedimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_next.setOnClickListener {
            animated_image.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.cat)
            )
        }

        button_pause.setOnClickListener {
            animated_image.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.)
            )
        }
    }
}
