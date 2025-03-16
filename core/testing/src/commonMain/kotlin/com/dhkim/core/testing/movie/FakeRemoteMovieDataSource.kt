package com.dhkim.core.testing.movie

import androidx.paging.PagingSource
import app.cash.paging.PagingConfig
import app.cash.paging.PagingData
import app.cash.paging.testing.TestPager
import app.cash.paging.testing.asPagingSourceFactory
import com.dhkim.common.Genre
import com.dhkim.domain.movie.datasource.RemoteMovieDataSource
import com.dhkim.domain.movie.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRemoteMovieDataSource : RemoteMovieDataSource {

    private val topRatedMovies = mutableListOf<Movie>().apply {
        repeat(50) {
            add(
                Movie(
                    id = "topRatedId$it",
                    title = "top rated title$it",
                    adult = false,
                    overview = "overview $it",
                    genre = listOf(Genre.ACTION.genre, Genre.DRAMA.genre),
                    imageUrl = "imageUrl$it",
                    releasedDate = "2025-03-13",
                    voteAverage = 5.5 + it.toDouble(),
                    popularity = 45.38 + it.toDouble(),
                    video = true
                )
            )
        }
    }

    private val nowPlayingMovies = mutableListOf<Movie>().apply {
        repeat(50) {
            add(
                Movie(
                    id = "nowPlayingId$it",
                    title = "now playing title$it",
                    adult = false,
                    overview = "overview $it",
                    genre = listOf(Genre.ACTION.genre, Genre.DRAMA.genre),
                    imageUrl = "imageUrl$it",
                    releasedDate = "2025-02-05",
                    voteAverage = 5.5 + it.toDouble(),
                    popularity = 45.38 + it.toDouble(),
                    video = true
                )
            )
        }
    }

    private val upcomingMovies = mutableListOf<Movie>().apply {
        repeat(50) {
            add(
                Movie(
                    id = "upcomingId$it",
                    title = "upcoming title$it",
                    adult = false,
                    overview = "overview $it",
                    genre = listOf(Genre.ACTION.genre, Genre.DRAMA.genre),
                    imageUrl = "imageUrl$it",
                    releasedDate = "2025-05-12",
                    voteAverage = 4.3 + it.toDouble(),
                    popularity = 45.38 + it.toDouble(),
                    video = true
                )
            )
        }
    }

    private val topRatedPagingSource = topRatedMovies.asPagingSourceFactory().invoke()
    private val nowPlayingPagingSource = nowPlayingMovies.asPagingSourceFactory().invoke()
    private val upcomingPagingSource = upcomingMovies.asPagingSourceFactory().invoke()

    override fun getTodayRecommendationMovie(language: String, region: String): Flow<PagingData<Movie>> {
        return flow {
            val recommendationMovie = nowPlayingMovies.maxBy { it.popularity }
            emit(PagingData.from(listOf(recommendationMovie)))
        }
    }

    override fun getTopRatedMovies(language: String, region: String): Flow<PagingData<Movie>> {
        return flow {
            val pager = TestPager(PagingConfig(pageSize = 15), topRatedPagingSource)
            val page = with(pager) {
                refresh()
                append()
            } as PagingSource.LoadResult.Page
            emit(PagingData.from(page.data))
        }
    }

    override fun getNowPlayingMovies(language: String, region: String): Flow<PagingData<Movie>> {
        return flow {
            val pager = TestPager(PagingConfig(pageSize = 15), nowPlayingPagingSource)
            val page = with(pager) {
                refresh()
                append()
            } as PagingSource.LoadResult.Page
            emit(PagingData.from(page.data))
        }
    }

    override fun getUpcomingMovies(language: String, region: String): Flow<PagingData<Movie>> {
        return flow {
            val pager = TestPager(PagingConfig(pageSize = 15), upcomingPagingSource)
            val page = with(pager) {
                refresh()
                append()
            } as PagingSource.LoadResult.Page
            emit(PagingData.from(page.data))
        }
    }
}