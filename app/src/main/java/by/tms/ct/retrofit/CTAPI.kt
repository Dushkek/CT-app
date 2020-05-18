package by.tms.ct.retrofit

import by.tms.ct.entity.RussianLanguage
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CTAPI {
    @GET("data/CT")
    fun getRussianLangeageTest(
        @Query("pageSize")
        pageSize:Int,
        @Query("groupBy")
        groupBy:String): Deferred<Response<RussianLanguage>>


}