package com.example.jpwanandroiddemon.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author JDK
 * @date 2020/6/23
 */
open class BaseVM<T> : ViewModel() {
    private var mLiveData: MutableLiveData<T>? = null
    val data: LiveData<T>
        get() {
            if (null == mLiveData) {
                mLiveData = MutableLiveData()
            }
            return mLiveData!!
        }

    fun setData(data: T) {
        mLiveData!!.postValue(data)
    }

    override fun onCleared() {
        super.onCleared()
    }
}