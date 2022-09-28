package com.gicproject.salamticketnumberapp.domain.use_case


import com.gicproject.emojisurveyapp.common.Resource
import com.gicproject.emojisurveyapp.domain.model.Location
import com.gicproject.salamticketnumberapp.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLocations @Inject constructor(
    private val repository: MyRepository
) {
    operator fun invoke(): Flow<Resource<List<Location>>> = flow {
        try {
            emit(Resource.Loading())

            var locations = repository.getLocations()
            if (!locations.isNullOrEmpty()) {
                emit(Resource.Success(locations.map {
                    it.toLocation()
                }))
            } else {
                emit(Resource.Error("Empty Location List."))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}