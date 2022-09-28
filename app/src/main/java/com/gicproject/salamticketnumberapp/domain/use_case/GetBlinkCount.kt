package com.gicproject.salamticketnumberapp.domain.use_case


import com.gicproject.emojisurveyapp.common.Resource
import com.gicproject.salamticketnumberapp.domain.model.BlinkingCount
import com.gicproject.salamticketnumberapp.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBlinkCount @Inject constructor(
    private val repository: MyRepository
) {
    operator fun invoke(): Flow<Resource<BlinkingCount>> = flow {
        try {
            emit(Resource.Loading())

            var locations = repository.getBlinkingCount()
            if (!locations.isNullOrEmpty()) {
                emit(Resource.Success(locations[0]))
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