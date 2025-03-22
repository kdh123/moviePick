package com.dhkim.home

import com.dhkim.core.testing.movie.FakeGetMovieWithCategoryUseCase
import com.dhkim.domain.movie.usecase.GetMovieWithCategoryUseCase
import com.dhkim.home.movie.MovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private lateinit var viewModel: MovieViewModel
    private lateinit var getMovieWithCategoryUseCase: GetMovieWithCategoryUseCase

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        getMovieWithCategoryUseCase = FakeGetMovieWithCategoryUseCase()
        viewModel = MovieViewModel(getMovieWithCategoryUseCase)
    }

    @Test
    fun `영화 가져오기 성공`() = runTest{
        viewModel.uiState.first()
        println("answer : ${viewModel.uiState.value}")
    }
}