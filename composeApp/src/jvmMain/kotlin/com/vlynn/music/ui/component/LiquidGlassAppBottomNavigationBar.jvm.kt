package com.vlynn.music.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vlynn.music.expect.ui.PlatformBackdrop
import com.vlynn.music.viewModel.SharedViewModel
import kotlin.reflect.KClass

@Composable
actual fun LiquidGlassAppBottomNavigationBar(
    startDestination: Any,
    navController: NavController,
    backdrop: PlatformBackdrop,
    viewModel: SharedViewModel,
    isScrolledToTop: Boolean,
    onOpenNowPlaying: () -> Unit,
    reloadDestinationIfNeeded: (KClass<*>) -> Unit
) {
}