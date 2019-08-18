package com.example.lentarss.rss.Lenta

import com.example.lentarss.rss.Lenta.RssObject.LentaRssObject
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET

interface LentaRss {
    @GET("rss.rss")
    fun getTitles() : Single<LentaRssObject>

    companion object Factory {
        fun create(): LentaRss {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://lenta.ru/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(LentaRss::class.java)
        }
    }
}