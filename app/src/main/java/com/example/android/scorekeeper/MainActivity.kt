package com.example.android.scorekeeper

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    private var mScore1: Int = 0
    private var mScore2: Int = 0
    private lateinit var mTextScore1: TextView
    private lateinit var mTextScore2: TextView

    val STATE_SCORE_1 = "Team 1 Score"
    val STATE_SCORE_2 = "Team 2 Score"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextScore1 = findViewById(R.id.score_1)
        mTextScore2 = findViewById(R.id.score_2)

        if(savedInstanceState != null){
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            mTextScore1.text = mScore1.toString()
            mTextScore2.text = mScore2.toString()
        }

    }

    fun decreaseScore(view: View){
        Toast.makeText(applicationContext, "Score decreased", Toast.LENGTH_SHORT).show()
        var viewId = view.id
        when (viewId) {
            R.id.decreaseTeam1 -> {
                mScore1--
                mTextScore1.text = mScore1.toString()
            }
            R.id.decreaseTeam2 -> {
                mScore2--
                mTextScore2.text = mScore2.toString()
            }
            else -> { // Note the block
                print("IDK")
            }
        }
    }

    fun increaseScore(view: View){
        Toast.makeText(applicationContext, "Score increased", Toast.LENGTH_SHORT).show()
        var viewId = view.id
        when (viewId) {
            R.id.increaseTeam1 -> {
                mScore1++
                mTextScore1.text = mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                mScore2++
                mTextScore2.text = mScore2.toString()
            }
            else -> { // Note the block
                print("IDK")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.night_mode){
            Toast.makeText(applicationContext, "Mode Switch Activated", Toast.LENGTH_SHORT).show()
            var nightMode = AppCompatDelegate.getDefaultNightMode()
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {

        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
