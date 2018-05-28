package com.woocommerce.android.ui.orders

import org.wordpress.android.fluxc.model.WCOrderModel

interface OrdersViewRouter {
    fun openOrderDetail(order: WCOrderModel)
    fun openOrderFulfillment(order: WCOrderModel)
    fun openOrderProductList(order: WCOrderModel)
}