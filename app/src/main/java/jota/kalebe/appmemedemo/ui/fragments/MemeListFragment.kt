package jota.kalebe.appmemedemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import jota.kalebe.appmemedemo.R
import jota.kalebe.appmemedemo.model.MemeHttp
import jota.kalebe.appmemedemo.ui.adapter.MemeListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_meme_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MemeListFragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_meme_list,  container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())

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