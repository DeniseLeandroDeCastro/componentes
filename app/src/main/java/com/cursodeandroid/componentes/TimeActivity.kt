package com.cursodeandroid.componentes

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_time.*
import kotlinx.android.synthetic.main.activity_time.text_mais_componentes
import java.text.SimpleDateFormat
import java.util.*

class TimeActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private val mSimpleDate = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        button_date.setOnClickListener(this)
        text_mais_componentes.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_date -> {
                val calendar = Calendar.getInstance()
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH)
                val year = calendar.get(Calendar.YEAR)
                DatePickerDialog(this, this, year, month, day).show()
            }
            R.id.text_mais_componentes -> {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }
    }
    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val date = Calendar.getInstance()
        date.set(year, month, dayOfMonth)
        button_date.text = mSimpleDate.format(date.time)
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}