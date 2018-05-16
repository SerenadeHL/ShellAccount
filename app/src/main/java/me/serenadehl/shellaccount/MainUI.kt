package me.serenadehl.shellaccount

import android.graphics.Color
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.PARENT_ID
import android.support.constraint.ConstraintSet.WRAP_CONTENT
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

//声明一个类继承AnkoComponent，对应泛型类到一个LayShowActivity，然后布局
class MainUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        constraintLayout {
            textView("测试Anko") {
                id = R.id.text_tv
                gravity = Gravity.CENTER
                textSize = 18f
                backgroundColor = Color.RED
            }.lparams(0, 0) {
                leftToLeft = ConstraintSet.PARENT_ID
                topToTop = ConstraintSet.PARENT_ID
                rightToRight = ConstraintSet.PARENT_ID
                matchConstraintPercentWidth = 0.5f
                matchConstraintPercentHeight = 0.5f
            }

            button("按钮") {
                setOnClickListener { toast("点击了按钮") }
                gravity = Gravity.CENTER
                textSize = 18f
                id = R.id.btn
                backgroundColor = Color.LTGRAY
            }.lparams(0, WRAP_CONTENT) {
                leftToLeft = R.id.text_tv
                rightToRight = R.id.text_tv
                topToBottom = R.id.text_tv
                topMargin = dip(10)
            }

            verticalLayout {
                backgroundColor = Color.CYAN

            }.lparams(0, 0) {
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
                topToBottom = R.id.btn
                bottomToBottom = PARENT_ID
            }
        }
    }
}