package com.p2pdm.parcial2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.p2pdm.parcial2.ui.components.ProductCard
import com.p2pdm.parcial2.viewmodel.ProductViewModel


@Composable
fun ProductListScreen(
    onProductClick: (Int) -> Unit,
    viewModel: ProductViewModel = viewModel()
) {
    val products by viewModel.filteredProducts
    val query by viewModel.searchQuery

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { viewModel.onSearchQueryChange(it) },
            label = { Text("Buscar producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(products) { product ->
                ProductCard(
                    product = product,
                    onClick = { onProductClick(product.id) },
                    onAddToCartClick = { viewModel.toggleAddToCart(product.id) }
                )
            }
        }
    }
}
