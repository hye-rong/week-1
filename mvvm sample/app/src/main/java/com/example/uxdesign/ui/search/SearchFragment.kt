package com.example.uxdesign.ui.search


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uxdesign.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    lateinit var adapter: SearchRecyclerViewAdapter
    private val placeViewModel: PlaceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearch()
        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        placeViewModel.placeList.observe(viewLifecycleOwner){
            adapter.submitList(it)
            Log.d("Test", it[0].place_name)
        }

    }

    private fun initSearch(){
        binding.searchBtn.setOnClickListener {
            placeViewModel.getPlaceList(binding.editText.text.toString())
            val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.editText.windowToken, 0)
        }

    }
    private fun initRecyclerView(){
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), 1))
        adapter = SearchRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
    }



}