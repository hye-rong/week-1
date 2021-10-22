package com.jslee.mvp_login_sample.UI.SignUp

interface SignUpContract {

    interface View {
        fun onFieldEmpty()

        fun onEmailEmpty()

        fun onPasswordEmpty()

        fun onUserNameEmpty()

        fun moveToInfoPage()

    }

    interface Presenter {

        fun bindView(view: View)

        fun dropView()

        fun registerInfo(email: String, password: String, userName: String)

    }

}