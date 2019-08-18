package com.example.lentarss.mvp.interfaces

import com.arellomobile.mvp.MvpView
import com.example.lentarss.adapters.Lenta.LentaAdapter

interface MainView: MvpView {
    fun showNews(adapter : LentaAdapter)
    fun showError()
}