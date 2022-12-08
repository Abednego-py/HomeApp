package com.example.homeapp.ui.welcome.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.homeapp.ui.welcome.notifications.data.Search
import com.example.homeapp.ui.welcome.notifications.data.SearchDao

class NotificationsViewModel(private val searchDao: SearchDao) : ViewModel() {

    val allSearches: LiveData<List<Search>> = searchDao.getSearchItems().asLiveData()

}