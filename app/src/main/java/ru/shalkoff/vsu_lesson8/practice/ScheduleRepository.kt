package ru.shalkoff.vsu_lesson8.practice

import ru.shalkoff.vsu_lesson6.models.RoutesResponse
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val scheduleApiService: ScheduleApiService
) {

    suspend fun getAllSchedule(): RoutesResponse {
        return scheduleApiService.getAllSchedule()
    }
}