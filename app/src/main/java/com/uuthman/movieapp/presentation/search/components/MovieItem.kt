package com.uuthman.movieapp.presentation.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.uuthman.movieapp.R
import com.uuthman.movieapp.ui.theme.LocalSpacing

@ExperimentalCoilApi
@Composable
fun MovieItem(
    title: String,
    type: String,
    image: String,
    modifier: Modifier = Modifier
){
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
    ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colors.onBackground)
            .align(Alignment.BottomCenter),
        ) {
           Column(modifier = Modifier
               .padding(start = 120.dp, top = 10.dp)
           ) {
               Text(
                  text = title,
                  style = MaterialTheme.typography.body1,
                  color = MaterialTheme.colors.onPrimary
               )
               Spacer(modifier = Modifier.height(spacing.spaceSmall))
               Text(
                   text = type,
                   style = MaterialTheme.typography.body2,
                   color = MaterialTheme.colors.onPrimary
               )
           }
        }
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
                .height(150.dp)
                .width(100.dp)
                .padding(start = 10.dp, bottom = 10.dp)
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(12.dp)),
        )
    }

}