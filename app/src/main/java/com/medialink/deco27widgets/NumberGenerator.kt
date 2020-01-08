package com.medialink.deco27widgets

import kotlin.random.Random

internal object NumberGenerator {
    fun generate(max: Int): Int = Random.nextInt(max)
}