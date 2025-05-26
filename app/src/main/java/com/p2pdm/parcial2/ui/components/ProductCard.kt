package com.p2pdm.parcial2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.p2pdm.parcial2.model.Product

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    onAddToCartClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = product.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "Categoría: ${product.category}")
                Text(text = "Precio: \$${product.price}")
            }


            Button(
                onClick = onAddToCartClick,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
               Text(if (product.addedToCart) "Quitar" else "Agregar")
            }
        }
    }
}
