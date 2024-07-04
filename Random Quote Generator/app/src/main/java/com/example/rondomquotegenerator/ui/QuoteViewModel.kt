package com.example.rondomquotegenerator.ui

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rondomquotegenerator.data.Model.QuoteModelItem
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuoteViewModel :ViewModel() {

    var mutableLiveData= MutableLiveData<List<QuoteModelItem>>()

    val repo=Repo()



        fun getQuote(){
            viewModelScope.launch(IO) {

                try {
                    val data=repo.getQuote()

                    withContext(Main){
                        mutableLiveData.value=data
                    }

                }
                catch (e:Exception){
                    throw e
                }

            }
        }


}