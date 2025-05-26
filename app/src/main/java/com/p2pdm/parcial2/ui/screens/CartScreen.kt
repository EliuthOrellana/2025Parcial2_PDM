package com.p2pdm.parcial2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.p2pdm.parcial2.ui.components.ProductCard
import com.p2pdm.parcial2.viewmodel.ProductViewModel

@Composable
fun CartScreen(
    viewModel: ProductViewModel = viewModel()
) {
    val cartItems = viewModel.getCartItems()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Carrito", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Text("El carrito está vacío.")
        } else {
            LazyColumn {
                items(cartItems) { product ->
                    ProductCard(
                        product = product,
                        onClick = {},
                        onAddToCartClick = { viewModel.toggleAddToCart(product.id) }
                    )
                }
            }
        }
    }
}
