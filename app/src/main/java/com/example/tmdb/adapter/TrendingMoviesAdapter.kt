package com.example.tmdb.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tmdb.databinding.SingleTrendingMovieDayWeekBinding
import com.example.tmdb.model.PopularMoviesModel

class TrendingMoviesAdapter :
    RecyclerView.Adapter<TrendingMoviesAdapter.TrendingMoviesItemViewHolder>() {
    inner class TrendingMoviesItemViewHolder(val binding: SingleTrendingMovieDayWeekBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val trendingMovies: ArrayList<PopularMoviesModel> = arrayListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingMoviesItemViewHolder {
        val binding =
            SingleTrendingMovieDayWeekBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TrendingMoviesItemViewHolder(binding)
    }

    override fun getItemCount() = trendingMovies.size

    override fun onBindViewHolder(holder: TrendingMoviesItemViewHolder, position: Int) {
        val popularMovie = trendingMovies[position]
        val posterPath = "https://image.tmdb.org/t/p/w500"
        with(holder) {
            with(popularMovie) {
                binding.trendingMoviesTv.text = this.popularMovieTitle
                binding.trendingMoviesIv.load("$posterPath${this.posterPath}")
            }
        }

    }

    fun updateTrendingMoviesList(updatedPopularMovies: ArrayList<PopularMoviesModel>) {
        trendingMovies.clear()
        trendingMovies.addAll(updatedPopularMovies)
        notifyDataSetChanged()
    }
}