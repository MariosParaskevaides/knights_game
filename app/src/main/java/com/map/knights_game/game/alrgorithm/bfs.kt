package com.map.knights_game.game.alrgorithm

import android.util.Log
import com.map.knights_game.utils.CoOrds
import com.map.knights_game.utils.Square
import java.util.*

//
class bfs() {
    //}
// Java program to find minimum steps to reach to
// specific cell in minimum moves by Knight
//object GFG {
    // Utility method returns true if (x, y) lies
    // inside Board
    fun isInside(x: Int, y: Int, N: Int): Boolean {
        return (x >= 1) && (x <= N) && (y >= 1) && (y <= N)
    }

    // Method returns minimum step
    // to reach target position
    private fun minStepToReachTarget(
        knightPos: IntArray,
        targetPos: IntArray,
        N: Int,
        steps: Int
//    ): Int {
    ): List<Square> {
        // x and y direction, where a knight can move
        val dx = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
        val dy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)


        // queue for storing states of knight in board
        val q: Queue<Square> = LinkedList()
        var listOfSquares = mutableListOf<Square>()

        // push starting position of knight with 0 distance
        q.add(Square(knightPos[0], knightPos[1], 0, knightPos[0], knightPos[1]))
        var t: Square
        var x: Int
        var y: Int
        var prevX: Int
        var prevY: Int
        val visit = Array(N + 1) {
            BooleanArray(
                N + 1
            )
        } // default initialized to false

        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true

        // loop until we have one element in queue
        while (!q.isEmpty()) {

            q.forEach { square ->
                listOfSquares.add(square)
            }

            t = q.poll()
            var listOfMoves = mutableListOf<Square>()

            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1] && t.dis <= steps) {


                var previousPos = t

                while ((previousPos.x != knightPos[0]) && (previousPos.y != knightPos[1])) {

                    previousPos = listOfSquares.find { square ->
                        square.y == previousPos.prevX &&
                                square.x == previousPos.prevY
                    }!!
                    if (!(previousPos.dis == 0))
                    previousPos?.let {
                        listOfMoves.add(Square(previousPos.y, previousPos.x, previousPos.dis, previousPos.prevX, previousPos.prevY)) }
                }
                listOfMoves.add(t)

                return listOfMoves
            }

            // loop for all reachable states
            for (i in 0..7) {
                prevX = t.x
                prevY = t.y
                x = t.x + dx[i]
                y = t.y + dy[i]

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true
                    q.add(Square(x, y, t.dis + 1, prevX, prevY))
                }
            }
        }
//        return Int.MAX_VALUE
        return emptyList<Square>()
    }

    fun main(array: List<CoOrds>, chessBoardSide: Int, steps: Int): List<Square> {
        val N = chessBoardSide

        array[0].col
        array[0].row
        array[1].col
        array[1].row

        val knightPos = intArrayOf(array[0].col, array[0].row)
        val targetPos = intArrayOf(array[1].col, array[1].row)

        // Function call
        Log.d("STEPS", "Steps Needed:$N")
        Log.d("STEPS", "Steps Needed:$N")
        println(
            minStepToReachTarget(knightPos, targetPos, N, steps)
        )
        return minStepToReachTarget(knightPos, targetPos, N, steps)
    }

}