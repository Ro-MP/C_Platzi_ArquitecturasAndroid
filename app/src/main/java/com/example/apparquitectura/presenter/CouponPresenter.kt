package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon

interface CouponPresenter {

    // Vista
    fun showCoupon(coupons: ArrayList<Coupon>?)

    // Interactor
    fun getCoupon()
}