package com.example.lentarss.mvp.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.lentarss.R
import com.example.lentarss.adapters.Lenta.LentaAdapter
import com.example.lentarss.mvp.interfaces.MainView
import com.example.lentarss.mvp.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity(this)
        presenter.init(this)
    }

    override fun showNews(adapter: LentaAdapter) {
        newsList.layoutManager = linearLayoutManager
        newsList.adapter = adapter
    }

    override fun showError() {
    }

    private fun initActivity(context : Context){
        linearLayoutManager = LinearLayoutManager(context)
    }
}
