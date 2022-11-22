package com.example.apparquitectura.model

import androidx.lifecycle.MutableLiveData

interface CouponsRepository {

    fun getCoupon(): MutableLiveData<List<Coupon>>
    fun callCouponAPI()
}