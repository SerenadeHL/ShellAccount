package me.serenadehl.shellaccount.ui

import io.reactivex.Observable
import me.serenadehl.shellaccount.R
import me.serenadehl.shellaccount.base.BaseActivity
import me.serenadehl.shellaccount.extensions.startActivity
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun layout() = R.layout.activity_splash

    override fun onActivityCreated() {
        Observable.timer(0, TimeUnit.SECONDS)
                .subscribe { startActivity<MainActivity>() }
    }
}
