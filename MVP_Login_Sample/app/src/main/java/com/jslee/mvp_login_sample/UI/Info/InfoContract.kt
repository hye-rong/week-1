package com.jslee.mvp_login_sample.UI.Info

interface InfoContract {

    interface View {

        fun displayInfo(email: String, password: String, userName: String)

        fun moveToLogin()
    }

    interface Presenter {
        fun bindView(view: View)

        fun dropView()

        fun fetchInfo()

        fun logout()
    }
}