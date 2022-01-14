package jota.kalebe.appmemedemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import jota.kalebe.appmemedemo.R
import jota.kalebe.appmemedemo.ui.adapter.MemePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = MemePagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager){ tab,position ->
            tab.setText(
                if(position == 0)
                    R.string.tab_meme
                else
                    R.string.tab_favorites
            )
        }.attach()

    }
}