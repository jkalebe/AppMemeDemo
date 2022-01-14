package jota.kalebe.appmemedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import jota.kalebe.appmemedemo.R
import jota.kalebe.appmemedemo.model.MemeHttp
import jota.kalebe.appmemedemo.ui.adapter.MemeListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)

        recyclerview.layoutManager = layoutManager
        object : Thread() {
            override fun run() {
                super.run()
                val result = MemeHttp.loadList()
                runOnUiThread {
                    result?.data?.memes?.let {
                        recyclerview.adapter = MemeListAdapter(it)
                    }
                }
            }
        }.start()

    }
}