package com.p2pdm.parcial2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.p2pdm.parcial2.viewmodel.ProductViewModel

@Composable
fun ProductDetailScreen(
    productId: Int,
    viewModel: ProductViewModel
) {
    val product = viewModel.getProductById(productId)

    if (product == null) {
        Text("Producto no encontrado", modifier = Modifier.padding(16.dp))
        return
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = product.name, style = MaterialTheme.typography.titleLarge)
        Text(text = "Categoría: ${product.category}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Precio: $${product.price}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = product.description, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { viewModel.toggleAddToCart(product.id) }) {
            Text(if (product.addedToCart) "Quitar del carrito" else "Agregar al carrito")
        }

    }
}
