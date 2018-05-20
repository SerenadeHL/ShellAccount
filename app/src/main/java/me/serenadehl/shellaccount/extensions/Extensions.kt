package me.serenadehl.shellaccount.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import me.serenadehl.shellaccount.BuildConfig
import me.serenadehl.shellaccount.utils.sharedpre.SPUtil
import java.io.Serializable
import android.support.v4.app.Fragment as SupportFragment
import android.app.Fragment as AppFragment

/**
 *
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2018-02-14 22:47:26
 */

/**
 * Toast
 */
fun Context.toast(msg: String) = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()

fun SupportFragment.toast(msg: String) = Toast.makeText(activity?.applicationContext, msg, Toast.LENGTH_SHORT).show()

fun AppFragment.toast(msg: String) = Toast.makeText(activity?.applicationContext, msg, Toast.LENGTH_SHORT).show()

private fun fillIntentArguments(intent: Intent, params: Array<out Pair<String, Any?>>) {
    params.forEach {
        val value = it.second
        when (value) {
            null -> intent.putExtra(it.first, null as Serializable?)
            is Int -> intent.putExtra(it.first, value)
            is Long -> intent.putExtra(it.first, value)
            is CharSequence -> intent.putExtra(it.first, value)
            is String -> intent.putExtra(it.first, value)
            is Float -> intent.putExtra(it.first, value)
            is Double -> intent.putExtra(it.first, value)
            is Char -> intent.putExtra(it.first, value)
            is Short -> intent.putExtra(it.first, value)
            is Boolean -> intent.putExtra(it.first, value)
            is Serializable -> intent.putExtra(it.first, value)
            is Bundle -> intent.putExtra(it.first, value)
            is Parcelable -> intent.putExtra(it.first, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> intent.putExtra(it.first, value)
                value.isArrayOf<String>() -> intent.putExtra(it.first, value)
                value.isArrayOf<Parcelable>() -> intent.putExtra(it.first, value)
                else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
            }
            is IntArray -> intent.putExtra(it.first, value)
            is LongArray -> intent.putExtra(it.first, value)
            is FloatArray -> intent.putExtra(it.first, value)
            is DoubleArray -> intent.putExtra(it.first, value)
            is CharArray -> intent.putExtra(it.first, value)
            is ShortArray -> intent.putExtra(it.first, value)
            is BooleanArray -> intent.putExtra(it.first, value)
            else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
        }
        return@forEach
    }
}

/**
 * 跳转
 */
fun Context.startActivity(activity: Class<out Activity>, vararg params: Pair<String, Any?>) {
    startActivity(Intent(this, activity).apply {
        if (params.isNotEmpty()) fillIntentArguments(this, params)
    })
}

fun SupportFragment.startActivity(activity: Class<out Activity>, vararg params: Pair<String, Any?>) {
    startActivity(Intent(getActivity(), activity).apply {
        if (params.isNotEmpty()) fillIntentArguments(this, params)
    })
}

fun AppFragment.startActivity(activity: Class<out Activity>, vararg params: Pair<String, Any?>) {
    startActivity(Intent(getActivity(), activity).apply {
        if (params.isNotEmpty()) fillIntentArguments(this, params)
    })
}


/**
 * 隐藏输入法
 *
 * @param view
 */
fun Context.hideKeyboard(view: View) {
    val imm = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

/**
 * 显示输入法
 *
 * @param view
 */
fun Context.showKeyboard(view: View) {
    val imm = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, 0)
}

fun SupportFragment.hideKeyboard(view: View) = activity?.hideKeyboard(view)

fun SupportFragment.showKeyboard(view: View) = activity?.showKeyboard(view)


fun AppFragment.hideKeyboard(view: View) = activity?.hideKeyboard(view)


fun AppFragment.showKeyboard(view: View) = activity?.showKeyboard(view)


/**
 * 设置虚拟按键颜色
 */
fun Activity.setNavigationBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor = color
    }
}

/**
 * log
 */
fun Any.log() {
    if (BuildConfig.DEBUG) Log.e("=========", toString())
}

/**
 * 保存到SP
 */
fun <T> T.saveToSP(key: String) = apply { SPUtil.putString(key, toString()) }