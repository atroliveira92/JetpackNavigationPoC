package com.venmo.features.credit_card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.venmo.entities.User

class CreditCardViewModel(user: User): ViewModel() {

    private var mutableMessage = MutableLiveData("Hello ${user.name} with id: ${user.id}")
    val message: LiveData<String> get() = mutableMessage

}