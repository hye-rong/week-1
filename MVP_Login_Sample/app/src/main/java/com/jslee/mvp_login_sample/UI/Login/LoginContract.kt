package com.jslee.mvp_login_sample.UI.Login

interface LoginContract {

    interface View {

        fun onFieldEmpty()

        fun onEmailEmpty()

        fun onPasswordEmpty()

        fun onLoginFailed()

        fun moveToSignUp()

        fun moveToUserInfo()

        fun showProgressBar()

        fun hideProgressBar()

    }

    interface Presenter {

        fun bindView(view: View)

        fun dropView()

        fun requestLogin(email: String, password: String)
    }
}