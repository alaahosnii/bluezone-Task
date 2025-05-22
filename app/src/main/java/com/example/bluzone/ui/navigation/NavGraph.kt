package com.example.bluzone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.bluzone.ui.screens.cart.CartScreen
import com.example.bluzone.ui.screens.cart.CartViewModel
import com.example.bluzone.ui.screens.productDetails.ProductDetailsScreen
import com.example.bluzone.ui.screens.productDetails.ProductDetailsViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val cartViewModel: CartViewModel = hiltViewModel()
    val productDetailsViewModel: ProductDetailsViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "product/5",
    ) {
        composable("product/{productId}" , arguments = listOf(
            navArgument("productId") {
                type = androidx.navigation.NavType.StringType
            }
        ),
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://bluzone.app/product/{productId}"
                }
            )
            ) {
            val productId = it.arguments?.getString("productId")
            ProductDetailsScreen(
                productId = productId ?: "5",
                productsViewModel = productDetailsViewModel,
                cartViewModel = cartViewModel,
                {
                    navController.navigate("cart")

                }
            ){ id ->
                navController.navigate("product/$id")
            }
        }
        composable("cart") {
             CartScreen(
                 cartViewModel = cartViewModel,
                 productsViewModel = productDetailsViewModel,
             ){
                    navController.popBackStack()
             }
        }
    }
}