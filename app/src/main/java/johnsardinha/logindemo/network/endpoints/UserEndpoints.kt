package johnsardinha.logindemo.network.endpoints;

import johnsardinha.logindemo.network.models.UserLoginPOJO
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserEndpoints {

    @FormUrlEncoded
    @POST("account/login/")
    fun login(@Field("username") username: String,
              @Field("password") password: String)
            : Call<UserLoginPOJO>

}