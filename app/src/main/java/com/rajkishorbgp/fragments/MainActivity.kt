package com.rajkishorbgp.fragments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.rajkishorbgp.fragments.Fragment.BookFragment
import com.rajkishorbgp.fragments.Fragment.ClothFragment
import com.rajkishorbgp.fragments.Fragment.ElectronicFragment
import com.rajkishorbgp.fragments.Fragment.GardenFragment
import com.rajkishorbgp.fragments.Fragment.HomeEssentialsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bookButton : Button
    private lateinit var electronicButton : Button
    private lateinit var clothItemsButton : Button
    private lateinit var gardenItemsButton : Button
    private lateinit var homeEssentialsButton : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookButton = findViewById(R.id.bookButton)
        electronicButton = findViewById(R.id.electronicButton)
        clothItemsButton = findViewById(R.id.clothItemsButton)
        gardenItemsButton = findViewById(R.id.gardenItemsButton)
        homeEssentialsButton = findViewById(R.id.homeEssentialsButton)

        loadFragment(BookFragment(),true)

        bookButton.setOnClickListener {
            loadFragment(BookFragment(),false)
        }
        electronicButton.setOnClickListener {
            loadFragment(ElectronicFragment(),false)
        }
        clothItemsButton.setOnClickListener {
            loadFragment(ClothFragment(),false)
        }
        gardenItemsButton.setOnClickListener {
            loadFragment(GardenFragment(),false)
        }
        homeEssentialsButton.setOnClickListener {
            loadFragment(HomeEssentialsFragment(),false)
        }
    }


    @SuppressLint("CommitTransaction")
    private fun loadFragment(fragment: Fragment, flog : Boolean){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (flog){
            fragmentTransaction.add(R.id.fragmentContainer,fragment)
        }else{
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        }
        fragmentTransaction.commit()
    }
}