package com.trendyol.base.component

abstract class BaseComponentViewModel<ViewData : BaseComponentViewData> {
    abstract fun handleInput(viewData: ViewData)

    open fun getViewData(): ViewData? = null
}