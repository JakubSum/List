package com.example.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
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

        //val inflatedView: View = layoutInflater.inflate(R.layout.custom_list_layout, null)
        //val imgB = inflatedView.findViewById<View>(R.id.imageButton) as ImageButton

        val arrayAdapter1: ArrayAdapter<*>
        val arrayAdapter2: ArrayAdapter<*>
        val dane1 = arrayListOf(
            "Numero Uno", "Cinco", "Noches", "Con", "Alfredo", "Monka", "Giga", "Numero Dos", "Chipi, chipi", "Chapa, chapa", "Dubi dubi", "Daba daba", "Monka", "Giga"
        )

        val dane2 = arrayListOf<String>()

        val myList1 = findViewById<ListView>(R.id.Lista1)
        val myList2 = findViewById<ListView>(R.id.Lista2)

        arrayAdapter1 = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, dane1)
        myList1.adapter = arrayAdapter1


        arrayAdapter2 = ArrayAdapter(this,
            android.R.layout.simple_list_item_multiple_choice, dane2)
        myList2.adapter = arrayAdapter2


        /*
        myList1.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Log.d("MainActivity.kt", selectedItem)
        }
        */

        val dataUp = findViewById<Button>(R.id.button)
        val dataDown = findViewById<Button>(R.id.button3)
        val dataClear = findViewById<Button>(R.id.button2)


        dataDown.setOnClickListener {
            val checkedPositions = myList1.checkedItemPositions
            val checkedItemsCount = myList1.checkedItemCount
            Log.d("Dół", "$checkedPositions")

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
            for (i in 0 until myList1.count) {
                val temp = arrayAdapter1.getItem(i) as String
                arrayAdapter1.remove(temp)
            }

            for (i in 0 until myList2.count) {
                val temp = arrayAdapter2.getItem(i) as String
                arrayAdapter2.remove(temp)
            }

            for (i in 0 until myList1.count) {
                val text = dane1[i]
                arrayAdapter1.add(text)
            }

            arrayAdapter1.notifyDataSetChanged()
            arrayAdapter2.notifyDataSetChanged()

            myList1.clearChoices()
            myList2.clearChoices()
        }









        /*
        dataDown.setOnClickListener {
            val checkedPosition = myList1.checkedItemPositions
            var checkedNumber = myList1.checkedItemCount
            Log.d("Dół","$checkedPosition")
            while(checkedNumber>=0){
                val item = arrayAdapter1.getItem(checkedPosition(checkedNumber)
                arrayAdapter1.remove(item)
                arrayAdapter2.add(item)
                arrayAdapter1.notifyDataSetChanged()
                arrayAdapter2.notifyDataSetChanged()
                myList1.clearChoices()
                myList2.clearChoices()
                checkedNumber--
            }

dataUp.setOnClickListener {
            val checkedPosition = myList2.checkedItemCount
            Log.d("Góra","$checkedPosition")
            if (checkedPosition != ListView.INVALID_POSITION) {
                val item = arrayAdapter2.getItem(checkedPosition)
                arrayAdapter2.remove(item)
                arrayAdapter1.add(item)
                arrayAdapter1.notifyDataSetChanged()
                arrayAdapter2.notifyDataSetChanged()
                myList1.clearChoices()
                myList2.clearChoices()
            }
        }

         */
            /*
            if (checkedPosition != ListView.INVALID_POSITION) {
                val item = arrayAdapter1.getItem(checkedPosition)
                arrayAdapter1.remove(item)
                arrayAdapter2.add(item)
                arrayAdapter1.notifyDataSetChanged()
                arrayAdapter2.notifyDataSetChanged()
                myList1.clearChoices()
                myList2.clearChoices()
            }
            */




        dataUp.setOnClickListener {
            val checkedPositions = myList2.checkedItemPositions
            val checkedItemsCount = myList2.checkedItemCount
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



        /*
        imgB.setOnClickListener {
            if (imgB.tag == "unchecked") {
                Log.d("MainActivity.kt","Giga klik")
                imgB.setImageResource(R.drawable.baseline_check_box_24)
                imgB.tag = "checked"
            } else {
                Log.d("MainActivity.kt","Giga klik numero dos")
                imgB.setImageResource(R.drawable.baseline_check_box_outline_blank_24)
                imgB.tag = "unchecked"
            }
        }
        */

        //Log.d("MainActivity", "myList1 is null: ${myList1 == null}")
        //Log.d("MainActivity", "myList2 is null: ${myList2 == null}")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}