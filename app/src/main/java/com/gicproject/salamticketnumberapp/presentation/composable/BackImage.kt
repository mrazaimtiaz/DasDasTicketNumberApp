package com.gicproject.salamticketnumberapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gicproject.salamticketnumberapp.R

@Composable
fun BackImage(navController: NavController){
    Image(
        painterResource(R.drawable.back),
        contentDescription = "ghp logo",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(80.dp, 80.dp).clickable {
                navController.popBackStack()
            }
    )
}