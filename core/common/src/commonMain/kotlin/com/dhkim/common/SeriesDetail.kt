package com.dhkim.common

import app.cash.paging.PagingData

interface SeriesDetail {

    val id: String
    val posterUrl: String
    val images: List<String>
    val title: String
    val adult: Boolean
    val overview: String
    val country: String
    val genre: List<String>
    val popularity: Double
    val productionCompany: String
    val actors: List<String>
    val review: PagingData<Review>
    val videos: List<Video>
    val openDate: String
    val isBookmarked: Boolean
}