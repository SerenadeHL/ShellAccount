package me.serenadehl.shellaccount.ui

import io.reactivex.*
import me.serenadehl.shellaccount.R
import me.serenadehl.shellaccount.base.BaseActivity
import me.serenadehl.shellaccount.extensions.*
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun layout() = R.layout.activity_splash

    override fun onActivityCreated() {
        Observable.timer(0, TimeUnit.SECONDS)
                .subscribe { startActivity(MainActivity::class.java) }
    }
}
