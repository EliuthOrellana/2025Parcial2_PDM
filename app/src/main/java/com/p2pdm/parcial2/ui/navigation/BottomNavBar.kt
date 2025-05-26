package com.p2pdm.parcial2.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.p2pdm.parcial2.model.Product

@Composable
fun BottomNavBar(
    currentRoute: String?,
    navigationActions: NavigationActions,
    selectedProduct: Product?
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { navigationActions.navigateToProductList() },
            icon = {Icon(Icons.Default.Search, contentDescription = "Inicio")},
            label = { Text("Home") }
        )

        selectedProduct?.let { product ->
            NavigationBarItem(
                selected = currentRoute?.startsWith("Product") == true,
                onClick = {navigationActions.navigateToProductDetail(product.id) },
                icon = {Icon(Icons.Default.Home, contentDescription = "Inicio")},
                label = { Text("product")}
            )
        }

        NavigationBarItem(
            selected = currentRoute == "cart",
            onClick = { navigationActions.navigateToCart() },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "cart") },
            label = { Text("Cart") }
        )
    }
}