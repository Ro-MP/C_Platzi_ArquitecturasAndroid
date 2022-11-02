package com.example.apparquitectura.model

import com.example.apparquitectura.presenter.CouponPresenter

class CouponsInteractorImpl(var couponPresenter: CouponPresenter): CouponsInteractor {

    private var couponRepository: CouponsRepository = CouponsRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponAPI()
    }
}