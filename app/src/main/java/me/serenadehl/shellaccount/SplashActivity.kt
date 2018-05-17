package me.serenadehl.shellaccount

import android.graphics.Color
import me.serenadehl.shellaccount.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun layout() = R.layout.activity_splash

    override fun onActivityCreated() {
        setStatusBarColor(Color.RED,true)
    }
}
