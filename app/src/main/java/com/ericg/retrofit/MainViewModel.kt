package com.ericg.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericg.retrofit.model.Post
import com.ericg.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val postsResponse : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val pushPostResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3 : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPosts(){
        viewModelScope.launch{
            val response = repository.getPosts()
            postsResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId)
            myResponse3.value = response
        }
    }

    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            pushPostResponse.value = response
        }
    }
}