package com.example.list

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val arrayAdapter1: ArrayAdapter<*>
        val arrayAdapter2: ArrayAdapter<*>
        val dane1 = arrayOf(
            "Numero Uno", "Cinco", "Noches", "Con", "Alfredo", "Monka", "Giga"
        )

        val dane2 = arrayOf(
            "Numero Dos", "Chipi, chipi", "Chapa, chapa", "Dubi dubi", "Daba daba", "Monka", "Giga"
        )

        val myList1 = findViewById<ListView>(R.id.Lista1)
        val myList2 = findViewById<ListView>(R.id.Lista2)

        arrayAdapter1 = ArrayAdapter(this,
            R.layout.custom_list_layout, R.id.customTextView, dane1)
        myList1.adapter = arrayAdapter1


        arrayAdapter2 = ArrayAdapter(this,
            R.layout.custom_list_layout, R.id.customTextView, dane2)
        myList2.adapter = arrayAdapter2





        //Log.d("MainActivity", "myList1 is null: ${myList1 == null}")
        //Log.d("MainActivity", "myList2 is null: ${myList2 == null}")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}