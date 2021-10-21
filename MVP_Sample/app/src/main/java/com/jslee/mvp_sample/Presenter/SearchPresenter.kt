package com.jslee.mvp_sample.Presenter

import android.os.Handler
import com.jslee.mvp_sample.Model.DogList
import com.jslee.mvp_sample.SearchContract

class SearchPresenter : SearchContract.Presenter {

    private var searchView: SearchContract.View? = null

    override fun bindView(view: SearchContract.View) {
        searchView = view
    }

    override fun dropView() {
        searchView = null
    }

    override fun getDogList() {
        searchView?.showProgressBarLoading()

        Handler().postDelayed({
            val dogList = DogList.getDogList()
            searchView?.showDogList(dogList)
            searchView?.hideProgressBarLoading()
        }, 1000)

    }
}