package com.example.weatherappmvi.domain.location

import android.location.Location
import kotlinx.coroutines.ExperimentalCoroutinesApi

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}