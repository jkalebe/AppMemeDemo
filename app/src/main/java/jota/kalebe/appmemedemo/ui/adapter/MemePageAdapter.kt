package jota.kalebe.appmemedemo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import jota.kalebe.appmemedemo.ui.fragments.MemeListFragment

class MemePagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            MemeListFragment()
        else
            Fragment()

    }

}