package com.example.trucoteste

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0

    private lateinit var pTimeA: TextView
    private lateinit var pTimeB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        val btrucoA: Button = findViewById(R.id.trucoA)
        val bcorreuA: Button = findViewById(R.id.correuA)
        val btrucoB: Button = findViewById(R.id.trucoB)
        val bccorreuB: Button = findViewById(R.id.correuB)
        val bReiniciar: Button = findViewById(R.id.reiniciarPartida)

        btrucoA.setOnClickListener { adicionarPontos(3, "A") }
        bcorreuA.setOnClickListener { adicionarPontos(1, "A") }
        btrucoB.setOnClickListener { adicionarPontos(3, "B") }
        bccorreuB.setOnClickListener { adicionarPontos(1, "B") }
        bReiniciar.setOnClickListener { reiniciarPartida() }


    }

    fun adicionarPontos(pontos: Int, time: String) {
        if(time == "A"){
            pontuacaoTimeA += pontos
            if(pontuacaoTimeA>=12) {
                vitoria(time);

            }
        }else {
            pontuacaoTimeB += pontos
            if(pontuacaoTimeB>=12) {
                vitoria(time);

            }
        }
        atualizaPlacar(time)
    }

    fun atualizaPlacar(time: String){
        if(time == "A"){
            pTimeA.setText(pontuacaoTimeA.toString())
        }else {
            pTimeB.setText(pontuacaoTimeB.toString())
        }
    }

    fun reiniciarPartida() {
        pontuacaoTimeA = 0
        pTimeA.setText(pontuacaoTimeA.toString())
        pontuacaoTimeB = 0
        pTimeB.setText(pontuacaoTimeB.toString())
        Toast.makeText(this,"Placar reiniciado", Toast.LENGTH_SHORT).show()

    }

    fun vitoria(time: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Vencedor !!")
        builder.setMessage("Time " +time + " ganhou")


        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
            reiniciarPartida()
        }

        builder.show()
    }
}