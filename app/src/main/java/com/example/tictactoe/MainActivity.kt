package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newGameButton = findViewById<Button>(R.id.NewGameButton)
        newGameButton.setOnClickListener {
            resetBoard()
        }

        // setting button click listeners
        val button1 = findViewById<Button>(R.id.Button1)
        val button2 = findViewById<Button>(R.id.Button2)
        val button3 = findViewById<Button>(R.id.Button3)
        val button4 = findViewById<Button>(R.id.Button4)
        val button5 = findViewById<Button>(R.id.Button5)
        val button6 = findViewById<Button>(R.id.Button6)
        val button7 = findViewById<Button>(R.id.Button7)
        val button8 = findViewById<Button>(R.id.Button8)
        val button9 = findViewById<Button>(R.id.Button9)
        button1.setOnClickListener {
            changeText(button1)
        }
        button2.setOnClickListener {
            changeText(button2)
        }
        button3.setOnClickListener {
            changeText(button3)
        }
        button4.setOnClickListener {
            changeText(button4)
        }
        button5.setOnClickListener {
            changeText(button5)
        }
        button6.setOnClickListener {
            changeText(button6)
        }
        button7.setOnClickListener {
            changeText(button7)
        }
        button8.setOnClickListener {
            changeText(button8)
        }
        button9.setOnClickListener {
            changeText(button9)
        }
    }

    private fun resetBoard() {
        val button1 = findViewById<Button>(R.id.Button1)
        button1.text = ""
        val button2 = findViewById<Button>(R.id.Button2)
        button2.text = ""
        val button3 = findViewById<Button>(R.id.Button3)
        button3.text = ""
        val button4 = findViewById<Button>(R.id.Button4)
        button4.text = ""
        val button5 = findViewById<Button>(R.id.Button5)
        button5.text = ""
        val button6 = findViewById<Button>(R.id.Button6)
        button6.text = ""
        val button7 = findViewById<Button>(R.id.Button7)
        button7.text = ""
        val button8 = findViewById<Button>(R.id.Button8)
        button8.text = ""
        val button9 = findViewById<Button>(R.id.Button9)
        button9.text = ""
        val instructionText = this.findViewById<TextView>(R.id.InstructionText)
        instructionText.text = "O's Turn"
    }

    private fun changeText(button: Button) {
        if (button.text == "") {
            val instructionText = this.findViewById<TextView>(R.id.InstructionText)
            if (instructionText.text.substring(0, 1) == "O") {
                button.text = "O"
                instructionText.text = "X's Turn"
            } else {
                button.text = "X"
                instructionText.text = "O's Turn"
            }
            isGameDone()
        }
    }

    private fun isGameDone() {
        if (threeInRow() || threeInColumn() || threeInDiagonal()) {
            val instructionText = this.findViewById<TextView>(R.id.InstructionText)
            val player = instructionText.text.substring(0, 1)
            instructionText.text = "$player wins!"
        }
    }

    private fun threeInColumn(): Boolean {
        // if there is three in a row in one of the columns
        // buttons in the left column have the same text value
        if ((findViewById<Button>(R.id.Button1).text == findViewById<Button>(R.id.Button4).text
                    && findViewById<Button>(R.id.Button1).text == findViewById<Button>(R.id.Button7).text)
            // buttons in the middle column have the same text value
            || (findViewById<Button>(R.id.Button2).text == findViewById<Button>(R.id.Button5).text
                    && findViewById<Button>(R.id.Button2).text == findViewById<Button>(R.id.Button8).text)
            // buttons in the right column have the same text value
            || (findViewById<Button>(R.id.Button3).text == findViewById<Button>(R.id.Button6).text
                    && findViewById<Button>(R.id.Button3).text == findViewById<Button>(R.id.Button9).text)
        ) {
            return true
        }
        // else return false
        return false
    }

    private fun threeInRow(): Boolean {
        // if there is three in a row in one of the rows
        // buttons in the top row have the same text value
        if ((findViewById<Button>(R.id.Button1).text == findViewById<Button>(R.id.Button2).text
                    && findViewById<Button>(R.id.Button1).text == findViewById<Button>(R.id.Button3).text)
            // buttons in the middle row have the same text value
            || (findViewById<Button>(R.id.Button4).text == findViewById<Button>(R.id.Button5).text
                    && findViewById<Button>(R.id.Button4).text == findViewById<Button>(R.id.Button6).text)
            // buttons in the bottom row have the same text value
            || (findViewById<Button>(R.id.Button7).text == findViewById<Button>(R.id.Button8).text
                    && findViewById<Button>(R.id.Button7).text == findViewById<Button>(R.id.Button9).text)
        ) {
            return true
        }
        // else return false
        return false
    }

    private fun threeInDiagonal(): Boolean {
        if ((findViewById<Button>(R.id.Button1).text == findViewById<Button>(R.id.Button5).text
                    && findViewById<Button>(R.id.Button1).text == findViewById<Button>(R.id.Button9).text)
            // buttons in the middle row have the same text value
            || (findViewById<Button>(R.id.Button3).text == findViewById<Button>(R.id.Button5).text
                    && findViewById<Button>(R.id.Button3).text == findViewById<Button>(R.id.Button7).text)
        ) {
            return true
        }
        // else return false
        return false
    }
}