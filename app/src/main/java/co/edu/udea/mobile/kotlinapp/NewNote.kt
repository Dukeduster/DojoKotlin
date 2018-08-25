package co.edu.udea.mobile.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import database.DBHelper
import kotlinx.android.synthetic.main.new_note.*
import model.note.Note

class NewNote : AppCompatActivity() {

    private var database :DBHelper ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_note)
        guardar.setOnClickListener{
            val title =titulo.text.toString()
            val body =texto.text.toString()
            var note = Note(title, body)
            database= DBHelper(this)
            database!!.insertNote(note)
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
        salir.setOnClickListener {
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }
}
