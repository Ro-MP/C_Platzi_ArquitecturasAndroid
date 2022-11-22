package com.example.apparquitectura.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {

    private var couponsRepository: CouponsRepository = CouponsRepositoryImpl()

    // Repositorio
    fun callCoupons(){
        couponsRepository.callCouponAPI()
    }


    // ViewModel
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponsRepository.getCoupon()
    }
}