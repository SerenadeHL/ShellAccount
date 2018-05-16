package me.serenadehl.shellaccount

import me.serenadehl.shellaccount.base.BaseActivity
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity() {

    override fun onActivityCreated() {
        var mRoot = MainUI();
        mRoot.setContentView(this)
    }

}
