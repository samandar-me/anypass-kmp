package io.spherelabs.designsystem.meterprogress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun LKMeterProgress(
    value: Int,
    modifier: Modifier = Modifier
) {

    val progressAngle by animateFloatAsState(
        targetValue = 180f / 15f * value,
        animationSpec = tween(500)
    )

    Box(
        modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        LKOuterProgress(modifier = modifier)
        LKCircleProgress(modifier = modifier, angle = progressAngle)
        LKDashProgress(modifier = modifier, value = value)
        LKInnerProgress(modifier = modifier)
    }
}