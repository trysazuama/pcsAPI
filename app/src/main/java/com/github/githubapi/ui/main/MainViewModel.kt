package com.github.githubapi.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.githubapi.api.RetrofitUser
import com.github.githubapi.data.model.User
import com.github.githubapi.data.model.userResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String) {
        RetrofitUser.apiInstance
                .getSearchUsers(query)
                .enqueue(object : Callback<userResponse> {
                    override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {
                        if (response.isSuccessful) {
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<userResponse>, t: Throwable) {
                        t.message?.let { Log.d("Failure", it) }
                    }
                })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>> {
        return listUsers
    }
}