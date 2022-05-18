package ru.sergeigaitanov.voroni

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    var counter = 0
    private var KEY_COUNT = "COUNT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Привет. Посчитаем ворон?"
        }
        button_counter.setOnClickListener {
            textView.text = "Ворон уже ${++counter}, а..."
            imageView.isVisible = counter >= 13
            imageView.visibility = if (counter >= 18) View.GONE else return@setOnClickListener
            hvatitJpg.isVisible = counter >= 18
            hvatitJpg.visibility = if (counter >= 22) View.GONE else return@setOnClickListener
            if (counter >= 22) {
                counter = 0
            } else return@setOnClickListener

        }
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNT, 0)
            textView.text = "Я насчитал " + counter + "ворон"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counter)
    }
}