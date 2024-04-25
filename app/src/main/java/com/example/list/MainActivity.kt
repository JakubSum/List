package com.example.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val arrayAdapter1: ArrayAdapter<*>
        val arrayAdapter2: ArrayAdapter<*>


        var dane1 = arrayListOf(
            "Numero Uno", "Cinco", "Noches", "Con", "Alfredo", "Monka", "Giga", "Numero Dos", "Chipi, chipi", "Chapa, chapa", "Dubi dubi", "Daba daba", "Monka", "Giga"
        )

        var dane2 = arrayListOf<String>()

        val dane3 = arrayListOf(
            "Numero Uno", "Cinco", "Noches", "Con", "Alfredo", "Monka", "Giga", "Numero Dos", "Chipi, chipi", "Chapa, chapa", "Dubi dubi", "Daba daba", "Monka", "Giga"
        )

        val dane4 = arrayListOf<String>()

        val myList1 = findViewById<ListView>(R.id.Lista1)
        val myList2 = findViewById<ListView>(R.id.Lista2)

        arrayAdapter1 = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, dane1)
        myList1.adapter = arrayAdapter1


        arrayAdapter2 = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, dane2)
        myList2.adapter = arrayAdapter2





        val dataUp = findViewById<Button>(R.id.button)
        val dataDown = findViewById<Button>(R.id.button3)
        val dataClear = findViewById<Button>(R.id.button2)


        dataDown.setOnClickListener {
            myList2.clearChoices()
            val checkedPositions = myList1.checkedItemPositions
            val checkedItemsCount = myList1.checkedItemCount
            Log.d("Dół", "$checkedPositions")
            Log.d("Drugi Dół", "$checkedItemsCount")

            val checkedPositionsList = mutableListOf<Int>()
            for (i in 0 until myList1.count) {
                if (checkedPositions[i]) {
                    checkedPositionsList.add(i)
                }
            }

            for (i in checkedPositionsList.indices.reversed()) {
                val position = checkedPositionsList[i]
                val item = arrayAdapter1.getItem(position) as String
                arrayAdapter1.remove(item)
                arrayAdapter2.add(item)
            }

            arrayAdapter1.notifyDataSetChanged()
            arrayAdapter2.notifyDataSetChanged()

            myList1.clearChoices()
            myList2.clearChoices()
        }


        dataClear.setOnClickListener {
            myList1.clearChoices()
            myList2.clearChoices()
            Log.d("Przed","$dane1")
            dane1.clear()
            for(i in 0 until dane3.count()) {
                dane1.add(dane3[i])
            }
            Log.d("Po","$dane1")
            dane2.clear()
            Log.d("Lista2","Działa")
            arrayAdapter1.notifyDataSetChanged()
            arrayAdapter2.notifyDataSetChanged()
        }


        dataClear.setOnLongClickListener{
            //Toast toast =
            Toast.makeText(this, "Czyści listę numer 2", Toast.LENGTH_SHORT).show()
            //toast.setGravity(Gravity.TOP or Gravity.LEFT, 0, 0)
            return@setOnLongClickListener true
        }



        dataUp.setOnClickListener {
            myList1.clearChoices()
            val checkedPositions = myList2.checkedItemPositions
            Log.d("Góra", "$checkedPositions")

            val checkedPositionsList = mutableListOf<Int>()
            for (i in 0 until myList2.count) {
                if (checkedPositions[i]) {
                    checkedPositionsList.add(i)
                }
            }

            for (i in checkedPositionsList.indices.reversed()) {
                val position = checkedPositionsList[i]
                val item = arrayAdapter2.getItem(position) as String
                arrayAdapter2.remove(item)
                arrayAdapter1.add(item)
            }

            arrayAdapter1.notifyDataSetChanged()
            arrayAdapter2.notifyDataSetChanged()

            myList1.clearChoices()
            myList2.clearChoices()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}