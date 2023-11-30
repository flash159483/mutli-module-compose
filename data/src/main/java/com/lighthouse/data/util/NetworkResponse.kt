package com.lighthouse.data.util

import android.util.Log
import retrofit2.Response

abstract class NetworkResponse {
    protected fun <T> changeResult(response: Response<T>): T {
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            Log.d("NetworkResponse", response.code().toString())
            throw Exception(response.message())
        }
    }
}
