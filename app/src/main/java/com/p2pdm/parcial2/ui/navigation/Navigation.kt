package com.p2pdm.parcial2.ui.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.p2pdm.parcial2.model.Product
import com.p2pdm.parcial2.ui.screens.CartScreen
import com.p2pdm.parcial2.ui.screens.ProductDetailScreen
import com.p2pdm.parcial2.ui.screens.ProductListScreen
import com.p2pdm.parcial2.viewmodel.ProductViewModel
import androidx.compose.runtime.setValue



@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel: ProductViewModel = viewModel()
    var product by remember { mutableStateOf<Product?>(null) }

    Scaffold (
        bottomBar = {
            BottomNavBar(
                currentRoute = navController.currentBackStackEntry?.destination?.route,
                navigationActions = NavigationActions(navController),
                selectedProduct = product,
            )}
    ){ padding ->


        NavHost(
            navController = navController,
            startDestination = "product_list",
            modifier = modifier.padding(padding)
        ) {
            composable("product_list") {
                ProductListScreen(
                    onProductClick = { productId ->
                        navController.navigate("product_detail/$productId")
                    },
                    viewModel = viewModel
                )
            }

            composable(
                route = "product_detail/{productId}",
                arguments = listOf(navArgument("productId") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                product = viewModel.getProductById(productId)
                ProductDetailScreen(
                    productId = productId,
                    viewModel = viewModel
                )
            }

            composable("cart") {
                CartScreen(viewModel = viewModel)
            }
        }
    }
}
