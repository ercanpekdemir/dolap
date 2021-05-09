package com.trendyol.dolap.component.countdown

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.trendyol.base.component.BaseComponentViewModel

class CircularCountDownViewModel: BaseComponentViewModel<CircularCountDownViewData>(), CountDownListener {

    companion object {
        private const val MAX_PROGRESS = 100
    }

    var handler: CircularCountDownHandler? = null

    var timer: CountDownUtil? = null
    var count = 0
    val progressObservable = ObservableInt(MAX_PROGRESS)
    val timerObservable = ObservableField<String>()

    override fun handleInput(viewData: CircularCountDownViewData) {
        viewData.apply {
            count = millsInFuture

            timerObservable.set(interval.toString())

            timer = CountDownUtil(millsInFuture.toLong(), interval.toLong(), this@CircularCountDownViewModel)
            timer?.start()
        }
    }

    override fun onTick(remainingTime: Int) {
        progressObservable.set(calculatePercentage(remainingTime, count))
        timerObservable.set(remainingTime.toString())
    }

    override fun onFinish() {
        progressObservable.set(MAX_PROGRESS)
        timerObservable.set(count.toString())
        timer?.cancel()
        handler?.onFinish()
    }

    fun startTimer() {
        timer?.start()
    }

    fun stopTimer() {
        timer?.cancel()
    }

    private fun calculatePercentage(remainingTime: Int, finish: Int) =
        (remainingTime.toFloat() / finish * MAX_PROGRESS).toInt()
}