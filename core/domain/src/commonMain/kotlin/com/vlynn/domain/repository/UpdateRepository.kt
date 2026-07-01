package com.vlynn.domain.repository

import com.vlynn.domain.data.model.update.UpdateData
import com.vlynn.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UpdateRepository {
    fun checkForGithubReleaseUpdate(): Flow<Resource<UpdateData>>
    fun checkForFdroidUpdate(): Flow<Resource<UpdateData>>
}