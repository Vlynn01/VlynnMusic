package com.vlynn.domain.data.model.home

import com.vlynn.domain.data.model.home.chart.Chart
import com.vlynn.domain.data.model.mood.Mood
import com.vlynn.domain.utils.Resource

data class HomeResponse(
    val homeItem: Resource<ArrayList<HomeItem>>,
    val exploreMood: Resource<Mood>,
    val exploreChart: Resource<Chart>,
)