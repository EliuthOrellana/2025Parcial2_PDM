package com.p2pdm.parcial2.ui.navigation

import androidx.navigation.NavHostController

class NavigationActions(private val navController: NavHostController) {
    fun navigateToProductList() {
        navController.navigate("product_list")
    }

    fun navigateToProductDetail(productId: Int) {
        navController.navigate("product_detail/$productId")
    }

    fun navigateToCart() {
        navController.navigate("cart")
    }
}