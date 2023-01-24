package com.map.knights_game

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.map.knights_game.game.alrgorithm.bfs
import com.map.knights_game.utils.CoOrds
import kotlin.math.ceil
import kotlin.properties.Delegates

//class ChessBoardView(context: Context?, attrs: AttributeSet?, dimension: Int) : View(context, attrs, dimension) {
class ChessBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    //    private var chessboardSize = DEFAULT_CHESS_MEASUREMENT
    private var chessboardSize = 12

    //  the side of the square
    private var squareSide = 0f

    //  private var start()
    private var fromCol: Int = -100
    private var fromRow: Int = -100
    private var toCol: Int = -100
    private var toRow: Int = -100
    private lateinit var listOfCoOrds: MutableList<CoOrds>

    //  width size
    private var usablecurrentWidth by Delegates.notNull<Int>()
    private val paint = Paint()


    override fun performClick(): Boolean {
        val boo = 0
        return super.performClick()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return false


        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //below ceil was used for better precision
                if (fromCol < 0) {
                    fromCol = ceil((event.x) / squareSide).toInt()
                    fromRow = ceil((((usablecurrentWidth - event.y) / (squareSide)))).toInt()
                    listOfCoOrds = mutableListOf(CoOrds(fromCol, fromRow))

                } else {
                    toCol = ceil((event.x) / squareSide).toInt()
                    toRow = ceil((((usablecurrentWidth - event.y) / (squareSide)))).toInt()
                    listOfCoOrds.add(CoOrds(toCol, toRow))
                }
                if ((fromCol != -100) && (toCol != -100)) checkKnightsMovement(listOfCoOrds)
            }
        }
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val desiredWidth: Int = widthSize
        val desiredHeight: Int = widthSize

        //measure width
        val width: Int = when (widthMode) {
            MeasureSpec.EXACTLY -> {
                widthSize.also {
                    usablecurrentWidth = it
                }

            }
            MeasureSpec.AT_MOST -> {
                Math.min(desiredWidth, widthSize)
            }
            else -> {
                desiredWidth
            }
        }

        //measure height
        val height: Int = when (heightMode) {
            MeasureSpec.EXACTLY -> {
                heightSize
            }
            MeasureSpec.AT_MOST -> {
                Math.min(desiredHeight, heightSize)
            }
            else -> {
                desiredHeight
            }
        }
        squareSide = (widthSize / chessboardSize).toFloat()
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        drawChessBoard(canvas)
    }

    private fun drawChessBoard(canvas: Canvas) {
        for (row in 0..chessboardSize.minus(1)) {
            for (col in 0..chessboardSize.minus(1)) {
                drawSquare(canvas, col, row)
            }
        }
    }

    private fun drawSquare(canvas: Canvas, col: Int, row: Int) {
        if ((row + col) % 2 == 1) {
            paint.color = resources.getColor(R.color.coral_light, resources.newTheme())
        } else {
            paint.color = resources.getColor(R.color.coral_dark, resources.newTheme())
        }

        canvas.drawRect(
            col * squareSide, row * squareSide,
            (col + 1) * squareSide, (row + 1) * squareSide, paint
        )

        paint.color
    }

    private fun checkKnightsMovement(list: List<CoOrds>) {

        knightsMovement(list)

//        if(list.size == 2) {
//            resetList()
//        }
    }

    private fun resetList() {
        //reseting list and variables
        listOfCoOrds.clear()
        fromCol = -100
        fromRow = -100
        toCol = -100
        toRow = -100
    }

    private fun knightsMovement(startEndPointsList: List<CoOrds>) {

        val startSquare = startEndPointsList.first()
        val endSquare = startEndPointsList.last()
        val solution = bfs()
        val knightsMoves = solution.main(startEndPointsList, chessboardSize, DEFAULT_STEPS)
        var movesString: String = ""

        knightsMoves.forEach { square ->
            movesString += getCharacter(square.x, square.y)
        }
        if (knightsMoves.isEmpty()) {
            Toast.makeText(
                context,
                "The knight either cannot reach the distance within 3 moves",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(context, movesString, Toast.LENGTH_LONG).show()
        }
        resetList()

    }

    private fun getCharacter(x: Int, y: Int): String {
        var character = x + 96

        return character.toChar().uppercaseChar().toString() + "$y "
    }

    fun knightImage() {

    }

    companion object {
        private const val DEFAULT_CHESS_MEASUREMENT = 8
        private const val DEFAULT_STEPS = 3
    }
}

