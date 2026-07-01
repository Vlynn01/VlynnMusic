package com.vlynn.music.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vlynn.domain.extension.now
import com.vlynn.music.ui.theme.typo
import com.vlynn.music.utils.VersionManager
import org.jetbrains.compose.resources.stringResource
import vlynnmusic.composeapp.generated.resources.Res
import vlynnmusic.composeapp.generated.resources.app_name
import vlynnmusic.composeapp.generated.resources.version_format

@Composable
fun EndOfPage(withoutCredit: Boolean = false) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(280.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        if (!withoutCredit) {
            Text(
                "@${now().year} " + stringResource(Res.string.app_name) + " " +
                    stringResource(
                        Res.string.version_format,
                        VersionManager.getVersionName(),
                    ) + "\nvlynn",
                style = typo().bodySmall,
                textAlign = TextAlign.Center,
                modifier =
                    Modifier
                        .padding(
                            top = 20.dp,
                        ).alpha(0.8f),
            )
        }
    }
}