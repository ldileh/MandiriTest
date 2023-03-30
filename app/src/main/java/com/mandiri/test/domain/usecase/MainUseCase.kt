package com.mandiri.test.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mandiri.core.base.BaseUseCase
import com.mandiri.test.domain.remote.MovieDataSource
import com.mandiri.test.domain.remote.RemoteDataSource
import com.mandiri.test.domain.remote.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Suppress("unused")
class MainUseCase @Inject constructor(
    private val remoteData: RemoteDataSource
): BaseUseCase() {

    suspend fun getMovieGenres() = handleResponse {
        remoteData.getMovieGenres()
    }

    fun discoverMovies(genres: List<Int>?): Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 2),
        pagingSourceFactory = { MovieDataSource(remoteData, genres) }
    ).flow
}
