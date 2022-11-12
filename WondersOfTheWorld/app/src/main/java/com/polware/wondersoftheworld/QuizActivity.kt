package com.polware.wondersoftheworld

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.polware.wondersoftheworld.databinding.ActivityQuizBinding
import com.polware.wondersoftheworld.model.QuizQuestions

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bindingQuiz: ActivityQuizBinding
    private var currentPosition: Int = 1
    private var questionsList: ArrayList<QuizQuestions>? = null
    private var selectedOptionPosition: Int = 0
    private var correctAnswers: Int = 0
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingQuiz = ActivityQuizBinding.inflate(layoutInflater)
        val view = bindingQuiz.root
        setContentView(view)

        userName = intent.getStringExtra(Constants.USER_NAME)
        questionsList = Constants.getQuestions()
        Log.i("Questions size", "${questionsList!!.size}")
        setQuestion()

        // Activamos el listener para toda la clase: View.OnClickListener
        bindingQuiz.textViewOption1.setOnClickListener(this)
        bindingQuiz.textViewOption2.setOnClickListener(this)
        bindingQuiz.textViewOption3.setOnClickListener(this)
        bindingQuiz.buttonSubmit.setOnClickListener(this)

    }

    private fun setQuestion() {
        val questionNumber = questionsList!![currentPosition - 1]
        defaultOptionsView()
        enableOptionsView()

        if (currentPosition == questionsList!!.size){
            bindingQuiz.buttonSubmit.text = "Finalizar"
        }
        else {
            bindingQuiz.buttonSubmit.text = "Responder"
        }

        bindingQuiz.progressBar.progress = currentPosition
        bindingQuiz.textViewNumberQuestion.text =
            "$currentPosition / " + bindingQuiz.progressBar.max
        bindingQuiz.textViewQuestion.text = questionNumber!!.question
        bindingQuiz.imageViewWonder.setImageResource(questionNumber.image)
        bindingQuiz.textViewOption1.text = questionNumber.optionOne
        bindingQuiz.textViewOption2.text = questionNumber.optionTwo
        bindingQuiz.textViewOption3.text = questionNumber.optionThree
    }

    // Definimos la vista por defecto para las 3 opciones de respuesta
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, bindingQuiz.textViewOption1)
        options.add(1, bindingQuiz.textViewOption2)
        options.add(2, bindingQuiz.textViewOption3)
        for (option in options){
            //option.setTextColor(Color.parseColor("#3A3D45"))
            option.setTextColor(resources.getColor(R.color.dark_gray))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.option_border_bg)
        }
    }

    // Click listener de cada opción de respuesta
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.textViewOption1 ->
                { selectedOptionView(bindingQuiz.textViewOption1, 1) }
            R.id.textViewOption2 ->
                { selectedOptionView(bindingQuiz.textViewOption2, 2) }
            R.id.textViewOption3 ->
                { selectedOptionView(bindingQuiz.textViewOption3, 3) }
            R.id.buttonSubmit -> {
                if(selectedOptionPosition == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
                            startActivity(intent)
                            finish()
                            //Toast.makeText(this, "Quiz Completed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                    val question = questionsList?.get(currentPosition - 1)
                    if (question!!.correctAnswer != selectedOptionPosition){
                        answerView(selectedOptionPosition, R.drawable.wrong_answer_bg)
                    }
                    else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_answer_bg)
                    if (currentPosition == questionsList!!.size) {
                        bindingQuiz.buttonSubmit.text = "Finalizar"
                    }
                    else {
                        bindingQuiz.buttonSubmit.text = "Siguiente Pregunta"
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(textView: TextView, optionNumber: Int) {
        defaultOptionsView()
        selectedOptionPosition = optionNumber
        //textView.setTextColor(Color.parseColor("#292B30"))
        textView.setTextColor(resources.getColor(R.color.med_black))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
    }

    private fun answerView(answer: Int, drawableView: Int){
        disableOptionsView()
        when(answer){
            1 -> {
                bindingQuiz.textViewOption1.background = ContextCompat
                    .getDrawable(this, drawableView)
                bindingQuiz.textViewOption1.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                bindingQuiz.textViewOption2.background = ContextCompat
                .getDrawable(this, drawableView)
                bindingQuiz.textViewOption2.setTextColor(Color.parseColor("#FFFFFF"))
            }
            3 -> {
                bindingQuiz.textViewOption3.background = ContextCompat
                .getDrawable(this, drawableView)
                bindingQuiz.textViewOption3.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }

    private fun disableOptionsView(){
        bindingQuiz.textViewOption1.isClickable = false
        bindingQuiz.textViewOption2.isClickable = false
        bindingQuiz.textViewOption3.isClickable = false
    }

    private fun enableOptionsView() {
        bindingQuiz.textViewOption1.isClickable = true
        bindingQuiz.textViewOption2.isClickable = true
        bindingQuiz.textViewOption3.isClickable = true
    }

}