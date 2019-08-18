package com.example.lentarss.mvp.presenters

import android.content.Context
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.lentarss.adapters.Lenta.LentaAdapter
import com.example.lentarss.mvp.interfaces.MainPMcontract
import com.example.lentarss.mvp.interfaces.MainView
import com.example.lentarss.mvp.models.MainModel
import com.example.lentarss.rss.Lenta.RssObject.LentaRssObject
import com.example.lentarss.rx.convayorDb
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class MainPresenter : MvpPresenter<MainView>(), MainPMcontract.presenter{

    private lateinit var model : MainModel
    private lateinit var ActCon: Context

    fun init(context: Context){
        model =  MainModel(this)
        model.downloadTitles(context)
        ActCon = context

    }

    override fun networkError() {
    }

    override fun readyToShow() {
        convayorDb.formaListFromDb(ActCon).subscribeBy(
            onError = { error -> Log.e("DBformater", error.message)},
            onComplete = { },
            onNext = { t -> val adapter : LentaAdapter = LentaAdapter(t)
                        viewState.showNews(adapter)})
    }
}