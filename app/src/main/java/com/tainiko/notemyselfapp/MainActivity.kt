package com.tainiko.notemyselfapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    lateinit var fragmentDay:FragmentDay
    lateinit var fragmentWeek:FragmentWeek
    lateinit var fragmentMonth:FragmentMonth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val adapter = ArrayAdapter(
            this@MainActivity,
            R.layout.custom_spinner,
            resources.getStringArray(R.array.list)
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, i: Int, l: Long) {
                when (i) {
                    0 -> setFragment(fragmentDay)
                    1 -> setFragment(fragmentWeek)
                    2 -> setFragment(fragmentMonth)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}


