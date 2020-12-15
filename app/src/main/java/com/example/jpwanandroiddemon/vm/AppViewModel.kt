package com.example.jpwanandroiddemon.vm

import androidx.lifecycle.ViewModel
import com.example.jpwanandroiddemon.callback.UnPeekLiveData

/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/12/15
 *     desc  :
 * </pre>
 */
class AppViewModel : ViewModel(){
    var appStatusColor  = UnPeekLiveData<Int>()

}