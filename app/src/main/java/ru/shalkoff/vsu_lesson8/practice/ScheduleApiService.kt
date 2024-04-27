package ru.shalkoff.vsu_lesson8.practice

import retrofit2.http.GET
import ru.shalkoff.vsu_lesson6.models.RoutesResponse
import ru.shalkoff.vsu_lesson8.practice.Const.API_SCHEDULE_ALL_URL

interface ScheduleApiService {

    @GET(API_SCHEDULE_ALL_URL)
    suspend fun getAllSchedule(): RoutesResponse
}