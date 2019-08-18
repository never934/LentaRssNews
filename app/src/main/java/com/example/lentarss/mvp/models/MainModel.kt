package com.example.lentarss.mvp.models

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.lentarss.mvp.interfaces.MainPMcontract
import com.example.lentarss.rss.Lenta.LentaRss
import com.example.lentarss.rss.Lenta.RssObject.LentaRssObject
import com.example.lentarss.rx.convayorDb
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainModel(val presenter: MainPMcontract.presenter): MainPMcontract.model {

    @SuppressLint("CheckResult")
    override fun downloadTitles(context: Context) {
        val rss = LentaRss.create()
        rss.getTitles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess =
                { t ->

                    Log.e("Retrofit", "success")
                    addToDB(t, context)
                },
                onError =
                { e -> Log.e("Retrofit", "error" + e.message); presenter.readyToShow() })
    }

    private fun addToDB(lentaObj : LentaRssObject, context: Context)
    {
        convayorDb.rewriteDb(lentaObj,context).subscribeBy(
            onError = { error -> Log.e("DBformater", error.message)},
            onComplete = {presenter.readyToShow() })
    }
}