package com.uuthman.movieapp.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uuthman.movieapp.ui.theme.LocalSpacing

@Composable
fun DetailCard(
    time: String,
    language: String,
    rated: String
){
    val spacing = LocalSpacing.current

   Card(
       modifier = Modifier
           .fillMaxSize()
           .height(120.dp)
           .padding(spacing.spaceMedium)
           .clip(RoundedCornerShape(12.dp))
           .background(color = MaterialTheme.colors.onBackground)
   ) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(10.dp),
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           Column {
               Text(
                   text = time,
                   style = MaterialTheme.typography.h3,
                   color = Color.White
               )
               Spacer(modifier = Modifier.height(spacing.spaceSmall))
               Text(
                   text = "Time",
                   style = MaterialTheme.typography.body1,
                   color = Color.Gray
               )
           }
           Column {
               Text(
                   text = language,
                   style = MaterialTheme.typography.h3,
                   color = Color.White
               )
               Spacer(modifier = Modifier.height(spacing.spaceSmall))
               Text(
                   text = "Language",
                   style = MaterialTheme.typography.body1,
                   color = Color.Gray
               )
           }
           Column {
               Text(
                   text = rated,
                   style = MaterialTheme.typography.h3,
                   color = Color.White
               )
               Spacer(modifier = Modifier.height(spacing.spaceSmall))
               Text(
                   text = "Rated",
                   style = MaterialTheme.typography.body1,
                   color = Color.Gray
               )
           }
       }
   }
}