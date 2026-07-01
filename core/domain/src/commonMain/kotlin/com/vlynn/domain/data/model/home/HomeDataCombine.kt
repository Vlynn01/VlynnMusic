package com.vlynn.domain.data.model.home

import com.vlynn.domain.data.model.home.chart.Chart
import com.vlynn.domain.data.model.mood.Mood
import com.vlynn.domain.utils.Resource

data class HomeDataCombine(
    val home: Resource<Pair<String?, List<HomeItem>>>,
    val mood: Resource<Mood>,
    val chart: Resource<Chart>,
    val newRelease: Resource<List<HomeItem>>,
)