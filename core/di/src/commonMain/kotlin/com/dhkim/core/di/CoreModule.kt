package com.dhkim.core.di

import com.dhkim.core.network.di.networkModule
import com.dhkim.core.network.di.platformModule
import com.dhkim.data.tv.datasource.RemoteTvDataSourceImpl
import com.dhkim.data.tv.repository.TvRepositoryImpl
import com.dhkim.data.tv.usecase.GetAiringTodayTvsUseCase
import com.dhkim.data.tv.usecase.GetOnTheAirTvsUseCase
import com.dhkim.data.tv.usecase.GetTopRatedTvsUseCase
import com.dhkim.domain.tv.datasource.RemoteTvDataSource
import com.dhkim.domain.tv.repository.TvRepository
import com.dhkim.domain.tv.usecase.GetTvsUseCase
import com.dhkim.data.usecase.GetNowPlayingMoviesUseCase
import com.dhkim.data.usecase.GetTopRatedMoviesUseCase
import com.dhkim.data.usecase.GetUpcomingMoviesUseCase
import com.dhkim.data.repository.MovieRepositoryImpl
import com.dhkim.data.datasource.RemoteMovieDataSourceImpl
import com.dhkim.domain.movie.datasource.RemoteMovieDataSource
import com.dhkim.domain.movie.repository.MovieRepository
import com.dhkim.domain.movie.usecase.GetMoviesUseCase
import com.dhkim.domain.movie.usecase.NOW_PLAYING_MOVIES_KEY
import com.dhkim.domain.movie.usecase.TOP_RATED_MOVIES_KEY
import com.dhkim.domain.movie.usecase.UPCOMING_MOVIES_KEY
import com.dhkim.domain.tv.usecase.AIRING_TODAY_TVS_KEY
import com.dhkim.domain.tv.usecase.ON_THE_AIR_TVS_KEY
import com.dhkim.domain.tv.usecase.TOP_RATED_TVS_KEY
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    includes(platformModule, networkModule)
    singleOf(::RemoteTvDataSourceImpl).bind<RemoteTvDataSource>()
    singleOf(::TvRepositoryImpl).bind<TvRepository>()
    factory<GetTvsUseCase>(named(AIRING_TODAY_TVS_KEY)) { GetAiringTodayTvsUseCase(get()) }
    factory<GetTvsUseCase>(named(ON_THE_AIR_TVS_KEY)) { GetOnTheAirTvsUseCase(get()) }
    factory<GetTvsUseCase>(named(TOP_RATED_TVS_KEY)) { GetTopRatedTvsUseCase(get()) }

    singleOf(::RemoteMovieDataSourceImpl).bind<RemoteMovieDataSource>()
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
    factory<GetMoviesUseCase>(named(TOP_RATED_MOVIES_KEY)) { GetTopRatedMoviesUseCase(get()) }
    factory<GetMoviesUseCase>(named(NOW_PLAYING_MOVIES_KEY)) { GetNowPlayingMoviesUseCase(get()) }
    factory<GetMoviesUseCase>(named(UPCOMING_MOVIES_KEY)) { GetUpcomingMoviesUseCase(get()) }

    factory {
        mapOf(
            AIRING_TODAY_TVS_KEY to get<GetTvsUseCase>(named(AIRING_TODAY_TVS_KEY)),
            ON_THE_AIR_TVS_KEY to get<GetTvsUseCase>(named(ON_THE_AIR_TVS_KEY)),
            TOP_RATED_TVS_KEY to get<GetTvsUseCase>(named(TOP_RATED_TVS_KEY)),
            TOP_RATED_MOVIES_KEY to get<GetMoviesUseCase>(named(TOP_RATED_MOVIES_KEY)),
            NOW_PLAYING_MOVIES_KEY to get<GetMoviesUseCase>(named(NOW_PLAYING_MOVIES_KEY)),
            UPCOMING_MOVIES_KEY to get<GetMoviesUseCase>(named(UPCOMING_MOVIES_KEY))
        )
    }
}
