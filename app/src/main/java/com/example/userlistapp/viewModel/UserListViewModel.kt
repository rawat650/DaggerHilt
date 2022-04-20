package com.example.userlistapp.viewModel

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userlistapp.pojo.UserDetails
import com.example.userlistapp.repo.UserRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRespository: UserRespository,
    @ApplicationContext private val context: Context
): ViewModel() {

    var userDetailLiveData = MutableLiveData<List<UserDetails>>()
    val errorMessage = MutableLiveData<String>()

    /*fun fetchDetails() {
        launchOnViewModelScope {
            userDetailLiveData.value = Resource.loading()
            apiCall<List<GetUserList>>(context) {
                onEnqueue = { userRespository.fetchDetails() }
                onSuccess = { status, data, successMessage ->
                    data?.let {
                        val profileDetails = UserDetails()
                        val userData : ArrayList<UserDetails> = ArrayList<UserDetails>()

                        it.forEachIndexed { index, getUserList ->
                            userData.add(UserDetails(getUserList.userId,getUserList.userName,getUserList.userImage,getUserList.userEmail))

                        }

                        userDetailLiveData.value = Resource.success(status,userData, successMessage)
                    }
                }
                onError = {
                    userDetailLiveData.value = Resource.error(it)
                }
            }
        }
    }*/
   fun fetchDetails(){
        val response = userRespository.fetchDetails()
        response.enqueue(object : Callback<List<UserDetails>>{
            override fun onResponse(
                call: Call<List<UserDetails>>,
                response: Response<List<UserDetails>>
            ) {
                userDetailLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UserDetails>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}

