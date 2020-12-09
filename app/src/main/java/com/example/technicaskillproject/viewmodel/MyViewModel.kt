package com.example.technicaskillproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technicaskillproject.model.Data
import com.example.technicaskillproject.model.Result
import com.example.technicaskillproject.model.service.ApiCall
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class MyViewModel : ViewModel() {
    //Get Data From the API and pass it to the activity as LiveData
    open fun passData(query: String): LiveData<List<com.example.technicaskillproject.model.Result>> {
        val liveData = MutableLiveData<List<Result>>()

        ApiCall().getDataFromAPI(query).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it != null) {
                    liveData.postValue(it.results)
                }
            }, {

            })

        return liveData
    }
}
