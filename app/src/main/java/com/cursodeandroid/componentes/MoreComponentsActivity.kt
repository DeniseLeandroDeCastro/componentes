package com.cursodeandroid.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_more_components.*

class MoreComponentsActivity : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_components)

        check_on_off.setOnCheckedChangeListener(this)
        radio_on.setOnCheckedChangeListener(this)
        radio_off.setOnCheckedChangeListener(this)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.check_on_off -> {
                toast("Checkbox: ${if (isChecked) "On" else "Off"}")
            }
            R.id.radio_on -> {
                toast("Radio Button On: ${if (isChecked) "On" else "Off"}")
            }
            R.id.radio_off -> {
                toast("Radio Button Off: ${if (isChecked) "On" else "Off"}")
            }
        }
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}