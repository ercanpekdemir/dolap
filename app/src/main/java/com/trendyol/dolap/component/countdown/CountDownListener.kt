package com.trendyol.dolap.component.countdown

interface CountDownListener {
    fun onTick(remainingTime: Int)
    fun onFinish()
}