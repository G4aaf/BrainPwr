package fr.isen.rouveure.brainpwr.quizz

object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(1, "Écoulement de la salive durant la journée ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question1)

        val question2 = Question(2, "Perte ou changement dans votre capacité à goûter ou à sentir ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question2)

        val question3 = Question(3, "Difficulté à avaler de la nourriture ou des liquides, ou problème d'étouffement ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question3)

        val question4 = Question(4, "Vomissement ou sensation de malaise (nausée) ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question4)

        val question5 = Question(5, "Constipation (moins de trois selles par semaine) ou avoir besoin de fournir un effort soutenu afin d'évacuer une selle ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question5)

        val question6 = Question(6, "Incontinence fécale (selle) ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question6)

        val question7 = Question(7, "Sensation que votre intestin n'est pas complètement vidé après être allé au toilette ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question7)

        val question8 = Question(8, "Sensation d'urgence urinaire qui vous fait courir pour aller au toilette ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question8)

        val question9 = Question(9, "Se lever régulièrement la nuit pour uriner ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question9)

        val question10 = Question(10, "Douleur inexpliquée (non causée par une maladie connue telle l'arthrite) ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question10)

        val question11 = Question(11, "Changement inexpliqué de votre poids (non causé par un changement de diète) ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question11)

        val question12 = Question(12, "Problème à se rappeler des choses qui se sont produites récemment ou oublier de faire des choses ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question12)

        val question13 = Question(13, "Perte d'intérêt pour ce qui se passe autour de vous ou pour des activités à faire ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question13)

        val question14 = Question(14, "Voir ou entendre des choses alors que vous savez, ou que l'on vous a dit, qu'elles ne sont pas là ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question14)

        val question15 = Question(15, "Difficulté à se concentrer ou à garder votre attention ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question15)

        val question16 = Question(16, "Sensation de tristesse, de déprime ou diminution de l'énergie ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question16)

        val question17 = Question(17, "Sensation d'anxiété, de peur, de panique ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question17)

        val question18 = Question(18, "Avoir moins d'intérêt pour la sexualité ou plus d'intérêt pour la sexualité ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question18)

        val question19 = Question(19, "Avoir des difficultés lors des relations sexuelles quand vous essayez? ", "Oui", "Je sais pas", "Non")
        questionList.add(question19)

        val question20 = Question(20, "Se sentir étourdi ou faible lorsque vous êtes debour après avoir été assis ou couché ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question20)

        val question21 = Question(21, "Chute ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question21)

        val question22 = Question(22, "Avoir de la difficulté à rester éveillé lors d'activités telles que travailler, conduire ou manger ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question22)

        val question23 = Question(23, "Difficulté à vous endormir la nuit ou à resté endormi durant la nuit ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question23)

        val question24 = Question(24, "Rêves intenses, d'apparence réelle ou cauchemars ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question24)

        val question25 = Question(25, "Parler ou bouger durant votre sommeil comme si vous 'actez' vos rêves ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question25)

        val question26 = Question(26, "Sensations désagréables dans vos jambes le soir ou lorsque vous vous reposez et une sensation que vous avez besoin de bouger ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question26)

        val question27 = Question(27, "Enflure de vos jambes ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question27)

        val question28 = Question(28, "Transpiration excessive ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question28)

        val question29 = Question(29, "Vision double ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question29)

        val question30 = Question(30, "Croire que des choses vous arrivent alors que d'autres personnnes vous disent que c'est faux ? ", "Oui", "Je sais pas", "Non")
        questionList.add(question30)

        return questionList
    }
}