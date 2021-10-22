package com.jslee.mvp_login_sample.Data.Login.Source

interface LoginRepository {

    var autoLogin: Boolean

    var userEmail: String

    var userPassword: String

    var userName: String
}