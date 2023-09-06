package com.xplor.android.challenge.repository

import com.xplor.android.challenge.database.XplorDatabase
import com.xplor.android.challenge.network.ApiService
import com.xplor.android.challenge.network.model.toPokedex
import com.xplor.android.challenge.network.model.toPokemon
import com.xplor.android.challenge.repository.models.Pokedex
import com.xplor.android.challenge.repository.models.Pokemon
import com.xplor.android.challenge.utils.ApiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val database: XplorDatabase
) {

    fun fetchApiList() = flow<ApiState<List<Pokemon>>> {
        // TODO: Get all pokemon data from API and the favorite pokemon from DB, merge both sources
        //  and emit the result back upstream.

    }.catch { throwable ->
        emit(ApiState.Error(throwable, throwable.message))
    }.onStart {
        emit(ApiState.Loading)
    }

    fun getAllFavoritePokemon() = flow<ApiState<List<Pokemon>>> {
        database.favoritePokemonDao().getAllFavoritePokemon().catch {throwable ->
            emit(ApiState.Error(throwable, throwable.message))
        }.onStart {
            emit(ApiState.Loading)
        }.collect{list ->
            emit(ApiState.Success(list))
        }
    }

    suspend fun setPokemonAsFavorite(pokemon: Pokemon) {
        database.favoritePokemonDao().insert(pokemon)
    }

    suspend fun removePokemonAsFavorite(pokemon: Pokemon) {
        database.favoritePokemonDao().delete(pokemon)
    }

}
