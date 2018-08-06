package com.example.avjindersinghsekhon.minimaltodo.AddToDo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity
import com.example.avjindersinghsekhon.minimaltodo.R
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    private var mTimerMinutes = 0
    private lateinit var mTimer: CountDownTimer
    private var mTimerFinished = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        mTimerMinutes = intent.extras["timerMinutes"] as Int

        val waitMils = mTimerMinutes * 60 * 1000L

        mTimer = object: CountDownTimer(waitMils, 500){
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutesUntilFinished = secondsRemaining / 60
                val secondsInMinuteUntilFinished = secondsRemaining - minutesUntilFinished * 60
                val secondsStr = secondsInMinuteUntilFinished.toString()

                textView.text = "$minutesUntilFinished:${if (secondsStr.length == 2) secondsStr else "0" + secondsStr}"
            }

            override fun onFinish() {
                textView.text = "Finish!"
                progressBar.visibility = View.GONE
                mTimerFinished = true
            }
        }.start()

        textView.setOnClickListener {
            if (mTimerFinished){
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
            }
        }
    }


}
