package com.dhkim.data.usecase

import androidx.paging.testing.asSnapshot
import app.cash.paging.PagingData
import com.dhkim.domain.movie.model.Movie
import com.dhkim.domain.movie.repository.MovieRepository
import com.dhkim.domain.movie.usecase.GetMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTodayRecommendationMovieUseCase(
    private val movieRepository: MovieRepository
) : GetMoviesUseCase {

    override fun invoke(language: String, region: String): Flow<PagingData<Movie>> {
        return flow {
            val index = (0..10).random()
            val nowPlayingMovies = movieRepository.getNowPlayingMovies(language, region)
                .asSnapshot()
                .take(10)[index]

            emit(PagingData.from(listOf(nowPlayingMovies)))
        }
    }
}