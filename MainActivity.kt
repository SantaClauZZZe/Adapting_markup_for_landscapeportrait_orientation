package com.example.rotate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var index = 0
    private lateinit var data : MutableList<Int>
    private lateinit var btn : Button
    private lateinit var pict : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = mutableListOf()
        data.add(R.drawable.car1)
        data.add(R.drawable.car2)
        data.add(R.drawable.car3)

        btn = findViewById(R.id.main_button)
        pict = findViewById(R.id.picture)

        btn.setOnClickListener {
            this.index = (this.index + 1)  % this.data.size
            pict.setImageResource(data[index])
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("index", index)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        this.index = savedInstanceState.getInt("index", 0)
        pict.setImageResource(data[index])
    }
}