package com.cursodeandroid.componentes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
        button_snack.setOnClickListener(this)
        loadSpinner()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_toast -> {
                val toast = Toast.makeText(this, "Toast", Toast.LENGTH_LONG)

                val layout = layoutInflater.inflate(R.layout.toast_layout, null)
                toast.view = layout

                toast.show()
            }
            R.id.button_snack -> {
                val snackbar = Snackbar.make(linear_root, "Essa é a SNACKBAR", Snackbar.LENGTH_LONG)
                snackbar.setAction("Desfazer", View.OnClickListener {
                    toast("Desfeito")
                })
                snackbar.setActionTextColor(Color.CYAN)
                snackbar.setBackgroundTint(Color.BLUE)
                snackbar.show()
            }
        }
    }

    private fun loadSpinner() {
        val mList = listOf("Gramas", "Kg", "Arroba", "Tonelada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mList)
        spinner_dynamic.adapter = adapter
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}