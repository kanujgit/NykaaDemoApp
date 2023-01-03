package com.nykaa.nykaademoapp.api

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val e: Any) : ApiState()
    class Success(val data: Any) : ApiState()
    object Empty : ApiState()
}