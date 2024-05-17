package com.example.icetaskrps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var computerChoiceImageView: ImageView
    private lateinit var rockImageView: ImageView
    private lateinit var paperImageView: ImageView
    private lateinit var scissorsImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        computerChoiceImageView = findViewById(R.id.computerChoiceImageView)
        rockImageView = findViewById(R.id.rockImageView)
        paperImageView = findViewById(R.id.paperImageView)
        scissorsImageView = findViewById(R.id.scissorsImageView)


        attachClickListener(rockImageView, "Rock")
        attachClickListener(paperImageView, "Paper")
        attachClickListener(scissorsImageView, "Scissors")


    }


    private fun attachClickListener(imageView: ImageView, choice: String) {
        imageView.setOnClickListener {
            playGame(choice)
        }
    }

    private fun playGame(Choice: String) {
        val choices = listOf("Rock", "Paper", "Scissors")
        val computerChoice = choices[ Random.nextInt(3)]



        //set computer Choice image
        when(computerChoice){
            "rock"->computerChoiceImageView.setImageResource(R.drawable.img_1)
        }
        when(computerChoice){
            "paper"->computerChoiceImageView.setImageResource(R.drawable.img)
        }
        when(computerChoice){
            "scissors"->computerChoiceImageView.setImageResource(R.drawable.img_2)
        }
        computerChoiceImageView.setImageResource(computerChoice)


        val result = when {
            Choice == computerChoice -> "It's a tie!"
            Choice == "Rock" && computerChoice == "Scissors" ||
                    Choice == "Paper" && computerChoice == "Rock" ||
                    Choice == "Scissors" && computerChoice == "Paper" -> "You win!"

            else -> "You lose!"
        }


        resultTextView.text = result
    }


}

private fun ImageView.setImageResource(computerChoice: String) {

}

private fun getImageResource(choice: String): Int {
    return when (choice) {
        "Rock" -> R.drawable.img_1
        "Paper" -> R.drawable.img
        "Scissors" -> R.drawable.img_2
        else -> throw IllegalArgumentException("Invalid choice")
    }
}
