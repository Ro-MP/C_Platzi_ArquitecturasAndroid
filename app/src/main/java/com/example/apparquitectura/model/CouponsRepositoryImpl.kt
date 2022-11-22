package com.example.apparquitectura.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponsRepositoryImpl(): CouponsRepository {

    private var coupons = MutableLiveData<List<Coupon>>()  // Lista de cupones del tipo liveData,
    // cualquier cambio que suceda en el puede refrescar automaticamente a los demas
    // Subject MutableLiveData
    // Observers List Coupons
    // Si List Coupon Change -> MutableLiveData change
    // Metodo Observer realiza cambios donde se requiera


    // Toda la logica de conexión
    override fun callCouponAPI() {
        var couponsList: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    couponsList?.add(coupon)
                }
                // View
                coupons.value = couponsList
            }
        })

    }

    override fun getCoupon(): MutableLiveData<List<Coupon>> {
        return coupons
    }
}