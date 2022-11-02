package com.example.apparquitectura.view

import com.example.apparquitectura.model.Coupon

interface CouponView {

    // Vista
    fun showCoupon(coupons: ArrayList<Coupon>?)

    // Presenter
    fun getCoupon()
}