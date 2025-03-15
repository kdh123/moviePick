package com.dhkim.tv.data.datasource

import androidx.paging.PagingConfig
import app.cash.paging.Pager
import app.cash.paging.PagingData
import com.dhkim.tv.domain.datasource.RemoteTvDataSource
import com.dhkim.tv.domain.model.Tv
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

internal class RemoteTvDataSourceImpl(
    private val apiService: HttpClient
) : RemoteTvDataSource {

    override fun getAiringTodayTvs(language: String): Flow<PagingData<Tv>> {
        return Pager(PagingConfig(pageSize = 15)) {
            AiringTodayTvPagingSource(apiService, language)
        }.flow
    }

    override fun getOnTheAirTvs(language: String): Flow<PagingData<Tv>> {
        return Pager(PagingConfig(pageSize = 15)) {
            OnTheAirTvPagingSource(apiService, language)
        }.flow
    }

    override fun getTopRatedTvs(language: String): Flow<PagingData<Tv>> {
        return Pager(PagingConfig(pageSize = 15)) {
            TopRatedTvPagingSource(apiService, language)
        }.flow
    }
}