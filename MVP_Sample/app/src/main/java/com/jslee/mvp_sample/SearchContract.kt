package com.jslee.mvp_sample

import com.jslee.mvp_sample.Model.Dog

interface SearchContract {

    interface View {
        fun showProgressBarLoading()

        fun hideProgressBarLoading()

        fun showDogList(dogList: List<Dog>)

    }

    interface Presenter {
        fun bindView(view: View)

        fun dropView()

        fun getDogList()

    }
}