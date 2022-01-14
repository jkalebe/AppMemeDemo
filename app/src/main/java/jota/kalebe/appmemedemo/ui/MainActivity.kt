package jota.kalebe.appmemedemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import jota.kalebe.appmemedemo.R
import jota.kalebe.appmemedemo.model.MemeHttp
import jota.kalebe.appmemedemo.ui.adapter.MemeListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)

        recyclerview.layoutManager = layoutManager

        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO){
                MemeHttp.loadList()
            }

                result?.data?.memes?.let {
                    recyclerview.adapter = MemeListAdapter(it)
                }

        }

    }
}