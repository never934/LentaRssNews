package com.example.lentarss.rx

import android.content.Context
import android.util.Log
import com.example.lentarss.rss.Lenta.RssObject.LentaRssObject
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import com.example.lentarss.db.AppDatabase
import androidx.room.Room
import com.example.lentarss.db.LentaDBobject


class convayorDb {
    companion object {
        fun rewriteDb(newsObj : LentaRssObject, context: Context): Observable<LentaRssObject> {
            val observable: Observable<LentaRssObject>
            observable = Observable.create(object : ObservableOnSubscribe<LentaRssObject> {
                override fun subscribe(emitter: ObservableEmitter<LentaRssObject>) {
                    try{
                        var ctr = 1
                        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database")
                            .build()
                        db.clearAllTables()
                        while(ctr<newsObj.lentaItem.size) {
                            val dbDao = db.lentaDao()
                            val lentaObject = LentaDBobject(ctr.toLong(),newsObj.lentaItem.get(ctr).title)
                            dbDao.insert(lentaObject)
                            ctr++
                        }
                        val dbDao = db.lentaDao()
                        Log.e("DB", dbDao.getAll().toString())
                        emitter.onComplete()
                    }catch(e: Exception){emitter.onError(e)}
                }
            }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
            return observable
        }

        fun formaListFromDb(context: Context): Observable<List<LentaDBobject>> {
            val observable: Observable<List<LentaDBobject>>
            observable = Observable.create(object : ObservableOnSubscribe<List<LentaDBobject>> {
                override fun subscribe(emitter: ObservableEmitter<List<LentaDBobject>>) {
                    try{
                        val db = Room.databaseBuilder(context, AppDatabase::class.java, "database")
                            .build()
                        val dbDao = db.lentaDao()
                        val list = dbDao.getAll()
                        emitter.onNext(list)
                    }catch(e: Exception){emitter.onError(e)}
                }
            }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
            return observable
        }
    }
}