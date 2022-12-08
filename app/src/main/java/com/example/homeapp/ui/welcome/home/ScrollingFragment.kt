package com.example.homeapp.ui.welcome.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homeapp.databinding.FragmentScrollingBinding
import com.example.homeapp.ui.welcome.home.data.CellClickListener
import com.example.homeapp.ui.welcome.home.data.Datasource
import com.example.homeapp.ui.welcome.home.data.Home

class ScrollingFragment : Fragment(), CellClickListener {
    private var _binding: FragmentScrollingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentScrollingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val myDataset = Datasource().loadImages()

        val recyclerView = binding.recylerList
        recyclerView.adapter = HomeScrollAdapter(myDataset, this)

        recyclerView.setHasFixedSize(true)

        return root

    }

    override fun onCellClickListener(data: Home) {
        val imageRes = data.imageResourceId
//        val home = Home(imageRes)
//        Toast.makeText(requireActivity(), home.imageResourceId.toString(), Toast.LENGTH_SHORT)
//            .show()
        val action = ScrollingFragmentDirections.actionNavigationScrollToHomeFragment3()

        findNavController().navigate(action)
    }
}