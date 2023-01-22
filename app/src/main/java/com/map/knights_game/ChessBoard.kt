package com.map.knights_game

import android.app.Application
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.core.content.res.ResourcesCompat.getColor

class ChessBoard(context: Context) : View(Application()) {
    var chessboardSize = 6
    private val paint = Paint()
    private val rectX = 10f


    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        for (i in 0..chessboardSize) {
//            for (j in 0..chessboardSize) {
//                paint.color = resources.getColor(R.color.coral_dark,resources.newTheme())
//                canvas?.drawRect(rectX, rectX, rectX, rectX, paint)
//                paint.color = resources.getColor(R.color.coral_light,resources.newTheme())
//                canvas?.drawRect(rectX, rectX, rectX, rectX, paint)
//            }
//        }
    }

}

//fun createChessBoard(chessBoardSize: Int, paint: Paint, canvas: Canvas?) {
//    for (i in 0..chessBoardSize) {
//        for (j in 0..chessBoardSize) {
//            paint.color =  Application().getColor( R.color.coral_dark)
//            canvas.drawRect(rectX)
//        }
//
//
//    }
//}