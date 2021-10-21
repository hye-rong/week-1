package com.jslee.mvp_sample.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jslee.mvp_sample.Model.Dog
import com.jslee.mvp_sample.Presenter.SearchPresenter
import com.jslee.mvp_sample.R
import com.jslee.mvp_sample.SearchContract
import com.jslee.mvp_sample.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(), SearchContract.View {
    private lateinit var binding: ActivitySearchBinding

    private lateinit var searchPresenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        searchPresenter.dropView()
    }

    private fun initView() {
        binding.searchButton.setOnClickListener {
            searchPresenter.getDogList()
        }
    }

    private fun initPresenter() {
        searchPresenter = SearchPresenter()
        searchPresenter.bindView(this)
    }

    override fun showProgressBarLoading() {
        binding.searchProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBarLoading() {
        binding.searchProgressBar.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun showDogList(dogList: List<Dog>) {
        binding.firstDogTextView.text = "${dogList[0].name} : ${dogList[0].age}세"
        binding.secondDogTextView.text = "${dogList[1].name} : ${dogList[1].age}세"
        binding.thirdDogTextView.text = "${dogList[2].name} : ${dogList[2].age}세"
    }
}