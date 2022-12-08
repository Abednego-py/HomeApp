package com.example.homeapp.ui.welcome.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.homeapp.databinding.FragmentHomeBinding
import com.example.homeapp.ui.welcome.home.data.CellClickListener
import com.example.homeapp.ui.welcome.home.data.Datasource
import com.example.homeapp.ui.welcome.home.data.Home
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment(), CellClickListener {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeAdapter: HomeAdapter
    val user = Firebase.auth.currentUser

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val myDataset = Datasource().loadImages()

        val recyclerView = binding.recylerList
        recyclerView.adapter = HomeAdapter(myDataset, this)

        recyclerView.setHasFixedSize(true)



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView14.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToNavigationScroll()
            this.findNavController().navigate(action)
        }

        binding.searchHome.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
//                if (programmingLanguagesList.contains(query)) {
//                    // if query exist within list we
//                    // are filtering our list adapter.
//                    listAdapter.filter.filter(query)
//                } else {
//                    // if query is not present we are displaying
//                    // a toast message as no  data found..
//                    Toast.makeText(requireContext(), "", Toast.LENGTH_LONG)
//                        .show()
//                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
//                listAdapter.filter.filter(newText)
                return false
            }
        })
        val name = user?.displayName
        val email = user?.email
        val photourl = user?.photoUrl

        binding.profilePix.setImageURI(photourl)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCellClickListener(data: Home) {
        val imageRes = data.imageResourceId
//        val home = Home(imageRes)
//        Toast.makeText(requireActivity(), home.imageResourceId.toString(), Toast.LENGTH_SHORT)
//            .show()
        val action = HomeFragmentDirections.actionNavigationHomeToHomeFragment3()

        findNavController().navigate(action)
//        Toast.makeText(requireActivity(),data.imageResourceId.toString(),Toast.LENGTH_SHORT).show()
    }


}