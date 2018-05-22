package me.serenadehl.shellaccount.ui

import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import me.serenadehl.shellaccount.R
import me.serenadehl.shellaccount.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun layout() = R.layout.activity_main

    override fun onActivityCreated() {
        setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        val data: ArrayList<String> = arrayListOf()
        for (i in 1 until 100) {
            if (i % 2 == 0)
                data.add("收入$i")
            else
                data.add("支出$i")
        }
        books_rv.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_books, data) {
            override fun convert(helper: BaseViewHolder, item: String?) {
                helper.setText(R.id.text_tv, item)
            }
        }
        books_rv.layoutManager = LinearLayoutManager(this)
        payment_rv.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_payment, data) {
            override fun convert(helper: BaseViewHolder, item: String) {
                if (item.contains("收入")) {
                    helper.setText(R.id.income_tv, item)
                    helper.setVisible(R.id.expenses_g, false)
                    helper.setVisible(R.id.income_g, true)
                } else {
                    helper.setText(R.id.expenses_tv, item)
                    helper.setVisible(R.id.income_g, false)
                    helper.setVisible(R.id.expenses_g, true)
                }
            }
        }
        payment_rv.layoutManager = LinearLayoutManager(this)

        payment_rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0)
                    menu.hideMenuButton(true)
                else
                    menu.showMenuButton(true)
            }
        })
    }
}
