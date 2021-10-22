package com.example.uxdesign.repository

import android.util.Log
import com.example.uxdesign.model.KakaoAPIService
import com.example.uxdesign.model.data.Place
import com.example.uxdesign.model.data.ResultSearchKeyword
import com.example.uxdesign.ui.MainActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

interface KakaoAPIRepository {
    suspend fun searchKeyword(keyword: String) : List<Place>
}