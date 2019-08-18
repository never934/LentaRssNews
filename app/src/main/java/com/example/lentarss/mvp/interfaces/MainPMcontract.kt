package com.example.lentarss.mvp.interfaces

import android.content.Context
import com.example.lentarss.rss.Lenta.RssObject.LentaRssObject

interface MainPMcontract {
    interface presenter{
        fun readyToShow()
        fun networkError()

    }
    interface model{
        fun downloadTitles(context : Context)
    }
}