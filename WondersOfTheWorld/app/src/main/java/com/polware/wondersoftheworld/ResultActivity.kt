package com.polware.wondersoftheworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.polware.wondersoftheworld.databinding.ActivityQuizBinding
import com.polware.wondersoftheworld.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var bindingResult: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingResult = ActivityResultBinding.inflate(layoutInflater)
        val view = bindingResult.root
        setContentView(view)

        // Hiding the status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.USER_NAME)
        bindingResult.textViewUserName.text = userName
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        bindingResult.textViewScore.text = "Su puntaje es: $correctAnswers aciertos de $totalQuestions"

        bindingResult.buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}