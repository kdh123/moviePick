package com.dhkim.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircleCloseButton(
    color: Color = MaterialTheme.colors.onBackground,
    backgroundColor: Color = Color.Transparent,
    size: Int = 36,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor)
            .border(
                width = 1.dp,
                color = color,
                shape = CircleShape
            )
            .size(size.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.Center)
        )
    }
}