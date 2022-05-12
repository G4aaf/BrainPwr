package fr.isen.rouveure.brainpwr.game

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.nfc.Tag
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import fr.isen.rouveure.brainpwr.R
import java.lang.Exception

class GameView(var c:Context, var gameTask : GameTask): View(c) {

    private var myPaint: Paint? = null
    private var speed = 1
    private var time = 0
    private var score = 0
    private var myPlayerPosition = 0
    private val eggs = ArrayList<HashMap<String,Any>>()

    var viewWidth = 0
    var viewHeight = 0
    init {
        myPaint = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        viewWidth = this.measuredWidth
        viewHeight = this.measuredHeight

        if (time % 700 < 10 + speed) {
            val map = HashMap<String,Any>()
            map["lane"] = (0..2).random()
            map["startTime"] = time
            eggs.add(map)
        }
        time = time + 10 + speed
        val eggsWidth = viewWidth / 5
        val eggsHeight = eggsWidth + 10
        myPaint!!.style = Paint.Style.FILL
        val d = resources.getDrawable(R.drawable.player, null)

        d.setBounds(
            myPlayerPosition * viewWidth / 3 + viewWidth /15 +25,
            viewHeight-2 - eggsHeight,
            myPlayerPosition * viewWidth / 3 + viewWidth / 15 + eggsWidth - 25,
            viewHeight - 2
        )

        d.draw(canvas!!)
        myPaint!!.color = Color.GREEN
        var highScore = 0

        for (i in eggs.indices){
            val value = try {
                val eggsX = eggs[i]["lane"] as Int * viewWidth / 3 + viewWidth / 15
                var eggsY = time - eggs[i]["startTime"] as Int
                val d2 = resources.getDrawable(R.drawable.eggs, null)

                d2.setBounds(
                    eggsX + 25, eggsY - eggsHeight, eggsX + eggsWidth - 25, eggsY
                )

                d2.draw(canvas)
                if (eggs[i]["lane"] as Int == myPlayerPosition) {
                    if (eggsY > viewHeight - 2 - eggsHeight
                        && eggsY < viewHeight - 2) {
                        gameTask.closeGame(score)
                    }
                }
                if (eggsY <= viewHeight + eggsHeight) {
                } else {
                    eggs.removeAt(i)
                    score++
                    speed = 1 + Math.abs(score / 8)
                    if (score <= highScore) {
                    } else {
                        highScore = score
                    }
                }
            }
            catch (e:Exception) {
                e.printStackTrace()
            }
        }
        myPaint!!.color = Color.WHITE
        myPaint!!.textSize = 40f
        canvas.drawText("Score : $score", 80f, 80f, myPaint!!)
        canvas.drawText("Speed : $speed", 380f, 80f, myPaint!!)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event!!.action){ // Quand tu appuie sur l'ecran
            MotionEvent.ACTION_MOVE -> { // l'action de déplacement s'éffectue
                val x1 = event.x  // x1 prend la position du joeur
                if (x1 < viewWidth/2) { // si x1 est inférieur a la taille de l'écran /2
                    if (myPlayerPosition >= 1 ) { // verification qu'il soit pas a l'étremiter gauche
                        Log.d("debug", ": if 1:  " + myPlayerPosition)
                        myPlayerPosition -= 1 // déplacer le joueur a gauche
                    }

                }
                if (x1 > viewWidth/2) { // si x1 est inférieur a la taille de l'écran /2

                    if (myPlayerPosition < 2  ) { // verification qu'il soit pas a l'étremiter droite
                        Log.d("debug", ": if 2: " + myPlayerPosition)
                        myPlayerPosition += 1 // déplacer le joeur a droite
                    }
                }
                invalidate()
            }
            MotionEvent.ACTION_UP -> {} // effectuer a chaque touche de l'écran
        }

        return true
    }
}