package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.CouponsInteractor
import com.example.apparquitectura.model.CouponsInteractorImpl
import com.example.apparquitectura.view.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter{

    private var couponInteractor: CouponsInteractor = CouponsInteractorImpl(this)

    override fun showCoupon(coupons: ArrayList<Coupon>?) {
        couponView.showCoupon(coupons)
    }

    override fun getCoupon() {
        couponInteractor.getCouponsAPI()
    }

}