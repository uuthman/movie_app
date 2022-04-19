package com.uuthman.movieapp.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.uuthman.movieapp.R
import com.uuthman.movieapp.ui.theme.LocalSpacing

@ExperimentalCoilApi
@Composable
fun DetailHeader(
    image: String,
    title: String,
    genre: String
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(350.dp)
    ) {
        val spacing = LocalSpacing.current
        Image(
            painter = rememberImagePainter(
                data = image,
                builder = {
                    error(R.drawable.moonlight)
                    fallback(R.drawable.moonlight)
                }
            ),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 300f
                ),
            )
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomStart)
            .padding(
                start = spacing.spaceMedium,
                bottom = spacing.spaceMedium
            ),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
            Text(
                text = genre,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary
            )
        }
        
    }
}