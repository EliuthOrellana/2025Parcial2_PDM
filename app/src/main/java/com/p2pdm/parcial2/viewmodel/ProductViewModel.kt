package com.p2pdm.parcial2.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.p2pdm.parcial2.data.productList
import com.p2pdm.parcial2.model.Product
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf


class ProductViewModel : ViewModel() {

    private val allProducts = productList

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _filteredProducts = mutableStateOf(allProducts)
    val filteredProducts: State<List<Product>> = _filteredProducts

    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery

        _filteredProducts.value = allProducts.filter { product ->
            product.name.contains(newQuery, ignoreCase = true) ||
                    product.category.contains(newQuery, ignoreCase = true) ||
                    product.description.contains(newQuery, ignoreCase = true)

        }
    }

    fun getProductById(id: Int): Product? {
        return allProducts.find { it.id == id }
    }

    fun toggleAddToCart(productId: Int) {
        val product = allProducts.find { it.id == productId }
        product?.let {
            it.addedToCart = !it.addedToCart
        }
    }

    fun getCartItems(): List<Product> {
        return allProducts.filter { it.addedToCart }
    }
}
