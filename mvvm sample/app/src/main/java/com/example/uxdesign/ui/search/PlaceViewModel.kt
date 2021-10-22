package com.example.uxdesign.ui.search


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uxdesign.model.data.Place
import com.example.uxdesign.repository.KakaoAPIRepositoryImpl
import kotlinx.coroutines.launch

class PlaceViewModel:ViewModel() {
    var placeList =  MutableLiveData<List<Place>>()
    fun getPlaceList(key: String){
        viewModelScope.launch {
            placeList.value = KakaoAPIRepositoryImpl.searchKeyword(key)
        }
    }

}