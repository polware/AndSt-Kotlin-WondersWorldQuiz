package com.polware.wondersoftheworld

import com.polware.wondersoftheworld.model.QuizQuestions

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<QuizQuestions> {
        val questionsList = ArrayList<QuizQuestions>()
        val question1 = QuizQuestions(1, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.chichen_itza, "Pirámide del Adivino",
            "Chichén Itzá", "Pirámide del Sol", 2)
        val question2 = QuizQuestions(2, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.coliseo_roma, "Anfiteatro de Arles",
            "Arena de Verona", "Coliseo de Roma", 3)
        val question3 = QuizQuestions(3, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.cristo_redentor, "Cristo Redentor",
            "Cristo Rey", "Jesús de la Misericordia", 1)
        val question4 = QuizQuestions(4, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.faro_alejandria, "Faro de Alejandría",
            "Faro de Porto Pí", "La Linterna de Génova", 1)
        val question5 = QuizQuestions(5, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.gran_muralla_china, "Muro de las Lamentaciones",
            "Muralla de Adriano", "La Gran Muralla China", 3)
        val question6 = QuizQuestions(6, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.gran_piramide_guiza, "Pirámide de La Danta",
            "Gran Pirámide de Guiza", "Necrópolis de Guiza", 2)
        val question7 = QuizQuestions(7, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.machu_picchu, "Ollantaytambo",
            "Choquequirao", "Machu Picchu", 3)
        val question8 = QuizQuestions(8, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.petra_jordania, "Petra",
            "Mádaba", "Monte Nebo", 1)
        val question9 = QuizQuestions(9, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.taj_mahal, "Tumba de Humayun",
            "Taj Mahal", "Templo Harmandir Sahib", 2)
        val question10 = QuizQuestions(10, "¿Cuál es el nombre de esta maravilla del mundo?",
            R.drawable.templo_artemisa, "Templo de Lúxor",
            "Stonehenge", "Templo de Artemisa", 3)

        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)
        questionsList.add(question6)
        questionsList.add(question7)
        questionsList.add(question8)
        questionsList.add(question9)
        questionsList.add(question10)
        return questionsList
    }

}