package com.dhkim.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import com.dhkim.home.movie.MovieAction
import com.dhkim.home.movie.MovieScreen
import com.dhkim.home.movie.MovieUiState

@Composable
@ExperimentalSharedTransitionApi
actual fun MovieScreenContainer(
    uiState: MovieUiState,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedContentScope,
    onAction: (MovieAction) -> Unit,
    navigateToVideo: (String) -> Unit,
    onBack: () -> Unit,
) {
    MovieScreen(
        uiState = uiState,
        sharedTransitionScope = sharedTransitionScope,
        animatedVisibilityScope = animatedVisibilityScope,
        onAction = onAction,
        navigateToVideo = navigateToVideo,
        onBack = onBack
    )
}