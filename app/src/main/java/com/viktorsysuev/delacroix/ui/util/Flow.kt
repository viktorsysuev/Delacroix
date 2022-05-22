package com.viktorsysuev.delacroix.ui.util

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

fun <T> Flow<T>.collectWhenStarted(
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    collector: FlowCollector<T>
) {
    lifecycleCoroutineScope.launchWhenStarted {
        this@collectWhenStarted.collect(collector)
    }
}

