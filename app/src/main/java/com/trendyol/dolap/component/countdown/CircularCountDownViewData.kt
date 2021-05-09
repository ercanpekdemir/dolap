package com.trendyol.dolap.component.countdown

import com.trendyol.base.component.BaseComponentViewData

data class CircularCountDownViewData(val millsInFuture: Int = 20, val interval: Int = 1):
    BaseComponentViewData