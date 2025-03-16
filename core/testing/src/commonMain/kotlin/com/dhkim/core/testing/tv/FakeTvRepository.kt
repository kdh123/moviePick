package com.dhkim.core.testing.tv

import app.cash.paging.PagingData
import com.dhkim.domain.tv.model.Tv
import com.dhkim.domain.tv.repository.TvRepository
import kotlinx.coroutines.flow.Flow

class FakeTvRepository : TvRepository {

    private val remoteTvDataSource = FakeRemoteTvDataSource()

    override fun getAiringTodayTvs(language: String): Flow<PagingData<Tv>> {
        return remoteTvDataSource.getAiringTodayTvs(language)
    }

    override fun getOnTheAirTvs(language: String): Flow<PagingData<Tv>> {
        return remoteTvDataSource.getOnTheAirTvs(language)
    }

    override fun getTopRatedTvs(language: String): Flow<PagingData<Tv>> {
        return remoteTvDataSource.getTopRatedTvs(language)
    }
}