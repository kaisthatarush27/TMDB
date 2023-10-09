package com.example.tmdb.model

import com.google.gson.annotations.SerializedName

data class PopularMoviesModel(
    @SerializedName("id") var popularMovieId: Int? = null,
    @SerializedName("poster_path") var posterPath: String? = null,
    @SerializedName("title") var popularMovieTitle: String? = null
)
