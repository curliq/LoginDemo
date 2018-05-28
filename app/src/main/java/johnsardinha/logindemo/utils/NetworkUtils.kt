package johnsardinha.logindemo.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object NetworkUtils {

    const val COURTY_PROD_BASE_URL: String = "https://courty.herokuapp.com"

    public fun getCourtyBaseUrl(): String {
        return COURTY_PROD_BASE_URL
    }

    public fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(getCourtyBaseUrl())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}