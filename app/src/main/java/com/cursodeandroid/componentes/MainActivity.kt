package com.cursodeandroid.componentes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener
, CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
        button_snack.setOnClickListener(this)
        button_get_spinner.setOnClickListener(this)
        button_set_spinner.setOnClickListener(this)


        spinner_static.onItemSelectedListener = this


        switch_on_off.setOnCheckedChangeListener(this)

        text_mais_componentes.setOnClickListener(this)
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
            R.id.button_get_spinner -> {
                val selectedItem = spinner_static.selectedItem
                val selectedItemId = spinner_static.selectedItemId
                val selectedItemPosition = spinner_static.selectedItemPosition

                toast("Position: $selectedItemId: $selectedItem")
            }
            R.id.button_set_spinner -> {
                spinner_static.setSelection(2)
            }

            R.id.text_mais_componentes -> {
                startActivity(Intent(applicationContext, MoreComponentsActivity::class.java))
            }
        }
        progress.visibility = View.GONE
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.switch_on_off -> {
                toast("Switch: ${if (isChecked) "Ligado" else "Desligado"}")
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id) {
            R.id.spinner_static -> {
                toast(parent?.getItemAtPosition(position).toString())
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        toast("Nothing")
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