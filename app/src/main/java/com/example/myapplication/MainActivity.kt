package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.button1)
        val btn2: Button = findViewById(R.id.button2)

        val frag1 = Fragment1()
        val frag2 = Fragment2()

        var transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame1, frag1)
        transaction.commit()

        btn1.setOnClickListener{
            println("Fragment1")
            transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame1, frag1)
            transaction.commit()
        }
        btn2.setOnClickListener{
            println("Fragment2")
            transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame1, frag2)
            transaction.commit()
        }
    }
}