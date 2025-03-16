package com.dhkim.core.testing.movie


import app.cash.paging.PagingData
import com.dhkim.domain.movie.model.Movie
import com.dhkim.domain.movie.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class FakeMovieRepository : MovieRepository {

    private val remoteMovieDataSource = FakeRemoteMovieDataSource()

    override fun getTodayRecommendationMovie(language: String, region: String): Flow<PagingData<Movie>> {
        return remoteMovieDataSource.getTodayRecommendationMovie(language, region)
    }

    override fun getTopRatedMovies(language: String, region: String): Flow<PagingData<Movie>> {
        return remoteMovieDataSource.getTopRatedMovies(language, region)
    }

    override fun getNowPlayingMovies(language: String, region: String): Flow<PagingData<Movie>> {
        return remoteMovieDataSource.getNowPlayingMovies(language, region)
    }

    override fun getUpcomingMovies(language: String, region: String): Flow<PagingData<Movie>> {
        return remoteMovieDataSource.getUpcomingMovies(language, region)
    }
}