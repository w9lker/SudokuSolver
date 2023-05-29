package com.example.sudokusolver

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var numArray = Array(9){IntArray(9){0} }
    private lateinit var matrix: Array<Array<TextView?>>
    private var generatedMatrix = Array(9){IntArray(9){0} }
    private lateinit var numPad: Array<Button?>
    private lateinit var remainingMoves: TextView
    private var issueCoordinates = IntArray(27){100}
    private var coordinate = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        remainingMoves = findViewById<TextView>(R.id.remainingMoves)

        matrix = Array(9) { arrayOfNulls<TextView>(9) }
        matrix[0][0] = findViewById<TextView>(R.id.textView0)
        matrix[0][1] = findViewById<TextView>(R.id.textView1)
        matrix[0][2] = findViewById<TextView>(R.id.textView2)
        matrix[0][3] = findViewById<TextView>(R.id.textView3)
        matrix[0][4] = findViewById<TextView>(R.id.textView4)
        matrix[0][5] = findViewById<TextView>(R.id.textView5)
        matrix[0][6] = findViewById<TextView>(R.id.textView6)
        matrix[0][7] = findViewById<TextView>(R.id.textView7)
        matrix[0][8] = findViewById<TextView>(R.id.textView8)
        matrix[1][0] = findViewById<TextView>(R.id.textView9)
        matrix[1][1] = findViewById<TextView>(R.id.textView10)
        matrix[1][2] = findViewById<TextView>(R.id.textView11)
        matrix[1][3] = findViewById<TextView>(R.id.textView12)
        matrix[1][4] = findViewById<TextView>(R.id.textView13)
        matrix[1][5] = findViewById<TextView>(R.id.textView14)
        matrix[1][6] = findViewById<TextView>(R.id.textView15)
        matrix[1][7] = findViewById<TextView>(R.id.textView16)
        matrix[1][8] = findViewById<TextView>(R.id.textView17)
        matrix[2][0] = findViewById<TextView>(R.id.textView18)
        matrix[2][1] = findViewById<TextView>(R.id.textView19)
        matrix[2][2] = findViewById<TextView>(R.id.textView20)
        matrix[2][3] = findViewById<TextView>(R.id.textView21)
        matrix[2][4] = findViewById<TextView>(R.id.textView22)
        matrix[2][5] = findViewById<TextView>(R.id.textView23)
        matrix[2][6] = findViewById<TextView>(R.id.textView24)
        matrix[2][7] = findViewById<TextView>(R.id.textView25)
        matrix[2][8] = findViewById<TextView>(R.id.textView26)
        matrix[3][0] = findViewById<TextView>(R.id.textView27)
        matrix[3][1] = findViewById<TextView>(R.id.textView28)
        matrix[3][2] = findViewById<TextView>(R.id.textView29)
        matrix[3][3] = findViewById<TextView>(R.id.textView30)
        matrix[3][4] = findViewById<TextView>(R.id.textView31)
        matrix[3][5] = findViewById<TextView>(R.id.textView32)
        matrix[3][6] = findViewById<TextView>(R.id.textView33)
        matrix[3][7] = findViewById<TextView>(R.id.textView34)
        matrix[3][8] = findViewById<TextView>(R.id.textView35)
        matrix[4][0] = findViewById<TextView>(R.id.textView36)
        matrix[4][1] = findViewById<TextView>(R.id.textView37)
        matrix[4][2] = findViewById<TextView>(R.id.textView38)
        matrix[4][3] = findViewById<TextView>(R.id.textView39)
        matrix[4][4] = findViewById<TextView>(R.id.textView40)
        matrix[4][5] = findViewById<TextView>(R.id.textView41)
        matrix[4][6] = findViewById<TextView>(R.id.textView42)
        matrix[4][7] = findViewById<TextView>(R.id.textView43)
        matrix[4][8] = findViewById<TextView>(R.id.textView44)
        matrix[5][0] = findViewById<TextView>(R.id.textView45)
        matrix[5][1] = findViewById<TextView>(R.id.textView46)
        matrix[5][2] = findViewById<TextView>(R.id.textView47)
        matrix[5][3] = findViewById<TextView>(R.id.textView48)
        matrix[5][4] = findViewById<TextView>(R.id.textView49)
        matrix[5][5] = findViewById<TextView>(R.id.textView50)
        matrix[5][6] = findViewById<TextView>(R.id.textView51)
        matrix[5][7] = findViewById<TextView>(R.id.textView52)
        matrix[5][8] = findViewById<TextView>(R.id.textView53)
        matrix[6][0] = findViewById<TextView>(R.id.textView54)
        matrix[6][1] = findViewById<TextView>(R.id.textView55)
        matrix[6][2] = findViewById<TextView>(R.id.textView56)
        matrix[6][3] = findViewById<TextView>(R.id.textView57)
        matrix[6][4] = findViewById<TextView>(R.id.textView58)
        matrix[6][5] = findViewById<TextView>(R.id.textView59)
        matrix[6][6] = findViewById<TextView>(R.id.textView60)
        matrix[6][7] = findViewById<TextView>(R.id.textView61)
        matrix[6][8] = findViewById<TextView>(R.id.textView62)
        matrix[7][0] = findViewById<TextView>(R.id.textView63)
        matrix[7][1] = findViewById<TextView>(R.id.textView64)
        matrix[7][2] = findViewById<TextView>(R.id.textView65)
        matrix[7][3] = findViewById<TextView>(R.id.textView66)
        matrix[7][4] = findViewById<TextView>(R.id.textView67)
        matrix[7][5] = findViewById<TextView>(R.id.textView68)
        matrix[7][6] = findViewById<TextView>(R.id.textView69)
        matrix[7][7] = findViewById<TextView>(R.id.textView70)
        matrix[7][8] = findViewById<TextView>(R.id.textView71)
        matrix[8][0] = findViewById<TextView>(R.id.textView72)
        matrix[8][1] = findViewById<TextView>(R.id.textView73)
        matrix[8][2] = findViewById<TextView>(R.id.textView74)
        matrix[8][3] = findViewById<TextView>(R.id.textView75)
        matrix[8][4] = findViewById<TextView>(R.id.textView76)
        matrix[8][5] = findViewById<TextView>(R.id.textView77)
        matrix[8][6] = findViewById<TextView>(R.id.textView78)
        matrix[8][7] = findViewById<TextView>(R.id.textView79)
        matrix[8][8] = findViewById<TextView>(R.id.textView80)

        numPad = arrayOf(
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9)
        )
    }

    fun clickGenerate(view: View?){
        //cleaning both numArray and matrix(array of TextViews)
        Helper.cleanArray(numArray)
        Helper.cleanArray(matrix)

        SudokuSolver.GenerateSudoku(numArray,0);
        for(i in 0..8){
            for(j in 0..8){
                if(numArray[i][j] != 0){
                    matrix[i][j]?.text = numArray[i][j].toString()
                    matrix[i][j]?.setTextColor(Color.BLACK)
                }
            }
        }

        for(i in 0..8 ){
            for(j in 0..8){
                generatedMatrix[i][j] = numArray[i][j]
            }
        }

        var displayText = "Remaining: ${Helper.numCellsLeft(numArray)}"
        remainingMoves.text = displayText

    }
    fun clickCell(textView:View?){
        var row:Int = coordinate / 9
        var column:Int = coordinate % 9
        matrix[row][column]?.setBackgroundColor(Color.WHITE)
        textView?.setBackgroundColor(Color.GRAY)
        for(i in 0..8){
            for(j in 0..8){
                if (matrix[i][j]?.id == textView?.id){
                    if(generatedMatrix[i][j] ==0){
                        coordinate = i*9+j
                    }
                    else{
                        textView?.setBackgroundColor(Color.WHITE)
                    }
                }
            }
        }
    }

    fun clicknumber(button:View?){
        var row:Int = coordinate / 9
        var column: Int = coordinate % 9
        for(i in 0..8){
            if(numPad[i]?.id == button?.id){
                matrix[row][column]?.text = (i+1).toString()
                matrix[row][column]?.setTextColor(Color.BLUE)
                numArray[row][column] = (i+1)
            }
        }
        //check for win
        var cellsLeft = Helper.numCellsLeft(numArray)
        if(cellsLeft == 0){
            if(SudokuSolver.isValid(numArray)){
                println("Niceee")
            }
            else{
                println("Sth is wrong")
            }
        }
        //check for conflicting cells


        //update the cells left
        var displayText = "Remaining: $cellsLeft"
        remainingMoves.text = displayText
    }

    fun clearCell(view: View?){
        var row = coordinate / 9
        var column = coordinate % 9
        matrix[row][column]?.text = ""
        numArray[row][column] = 0
    }

    fun solve(view: View?){
        var originalMatrix = Array(9){IntArray(9){0} }
        for(i in 0..8){
            for(j in 0..8){
                originalMatrix[i][j] = generatedMatrix[i][j]
            }
        }

        SudokuSolver.solveSudoku(generatedMatrix)
        for(i in 0..8){
            for(j in 0..8){
                if(originalMatrix[i][j] == 0){
                    matrix[i][j]?.text = generatedMatrix[i][j].toString()
                    matrix[i][j]?.setTextColor(Color.BLACK)
                    if(numArray[i][j] != 0){
                        if(numArray[i][j] == generatedMatrix[i][j]){
                            matrix[i][j]?.setBackgroundColor(Color.GREEN)
                        }
                        else if(numArray[i][j] != generatedMatrix[i][j]){
                            matrix[i][j]?.setBackgroundColor(Color.RED)
                        }
                    }
                }
            }
        }
    }
}