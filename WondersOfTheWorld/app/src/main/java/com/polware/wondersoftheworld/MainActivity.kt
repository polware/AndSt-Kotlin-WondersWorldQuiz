package com.polware.wondersoftheworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.polware.wondersoftheworld.databinding.ActivityMainBinding
import com.polware.wondersoftheworld.R

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Hiding the status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Custom animation for button click
        val myAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.clickeffect)

        binding.buttonStart.setOnClickListener{
            binding.buttonStart.startAnimation(myAnim);
            if (binding.editTextName.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.editTextName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }

}