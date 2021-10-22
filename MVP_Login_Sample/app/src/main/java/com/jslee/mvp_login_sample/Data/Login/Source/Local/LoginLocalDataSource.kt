package com.jslee.mvp_login_sample.Data.Login.Source.Local

interface LoginLocalDataSource {
    var autoLogin: Boolean

    var userEmail: String

    var userPassword: String

    var userName: String
}