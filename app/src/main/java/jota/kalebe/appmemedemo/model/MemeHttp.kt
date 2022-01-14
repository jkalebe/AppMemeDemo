package jota.kalebe.appmemedemo.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object MemeHttp{
    val URL_LIST_JSON="https://api.imgflip.com/get_memes"
    val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun loadList(): ResultData? {
        val request = Request.Builder()
            .url(URL_LIST_JSON)
            .build()

        try {
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            return Gson().fromJson(json, ResultData::class.java)
        } catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }
}