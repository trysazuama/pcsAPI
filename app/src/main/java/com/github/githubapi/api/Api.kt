package com.github.githubapi.api

import com.github.githubapi.data.model.DetailUserResponse
import com.github.githubapi.data.model.User
import com.github.githubapi.data.model.userResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users?q=sidiqpermana")
    @Headers("Authorization: token personal")
    fun getSearchUsers(
            @Query("q") query: String
    ): Call<userResponse>

    @GET("users/{username}")
    @Headers("Authorization: token personal")
    fun getUserDetail(
            @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token personal")
    fun getFollowers(
            @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token personal")
    fun getFollowing(
            @Path("username") username: String
    ): Call<ArrayList<User>>
}