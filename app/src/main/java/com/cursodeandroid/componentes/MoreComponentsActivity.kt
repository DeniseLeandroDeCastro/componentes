package com.cursodeandroid.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_more_components.*

class MoreComponentsActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_components)

        button_get_seekbar.setOnClickListener(this)
        button_set_seekbar.setOnClickListener(this)
        check_on_off.setOnCheckedChangeListener(this)
        radio_on.setOnCheckedChangeListener(this)
        radio_off.setOnCheckedChangeListener(this)
        seekbar.setOnSeekBarChangeListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_get_seekbar -> {
                toast("Seekbar: ${seekbar.progress}")
            }
            R.id.button_set_seekbar -> {
                seekbar.progress = 10
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.check_on_off -> {
                toast("Checkbox: ${if (isChecked) "On" else "Off"}")
            }
            R.id.radio_on -> {
                toast("Radio ButtonOn: ${if (isChecked) "On" else "Off"}")
            }
            R.id.radio_off -> {
                toast("Radio ButtonOff: ${if (isChecked) "On" else "Off"}")
            }
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        text_seekbar_value.text = "Valor seekbar: $progress"
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        toast("Track started")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        toast("Track stoped")
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}