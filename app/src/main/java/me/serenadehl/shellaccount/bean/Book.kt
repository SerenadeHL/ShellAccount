package me.serenadehl.shellaccount.bean

/**
 * 作者：Serenade
 * 邮箱：SerenadeHL@163.com
 * 创建时间：2018-05-20 20:27:50
 */
data class Book(val name: String,
                val remainingSum: Float,
                val totalIncome: Float,
                val totalExpenses: Float,
                val createAt: String)