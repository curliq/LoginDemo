package johnsardinha.logindemo.app.login

import android.util.Patterns
import johnsardinha.logindemo.network.endpoints.UserEndpoints
import johnsardinha.logindemo.network.models.UserLoginPOJO
import johnsardinha.logindemo.utils.NetworkUtils
import johnsardinha.logindemo.utils.PASSWORD_MIN_LENGTH
import johnsardinha.logindemo.utils.log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInPresenter(private val loginView: LogInContract.View) : LogInContract.Presenter {

    private var emailString: String = ""
    private var passwordString: String = ""

    init {
        loginView.presenter = this
    }

    override fun start() {
        loginView.disablePassword()
        loginView.disableLoginButton()
    }

    override fun login(email: String, password: String) {
        loginView.startLoading()
        loginView.disableLoginButton()
        NetworkUtils.getRetrofit().create(UserEndpoints::class.java)
                .login(email, password).enqueue(object : Callback<UserLoginPOJO> {
                    override fun onResponse(call: Call<UserLoginPOJO>?, response: Response<UserLoginPOJO>?) {
                        loginView.enableLoginButton()
                        loginView.stopLoading()
                        if (response != null) {
                            if (response.isSuccessful) {
                                log(response.body()!!.token)
                                loginView.successfullyLoggedIn()
                            }
                            else
                                loginView.showErrorMessage("Can't log in with those credentials")
                        }
                        else
                            loginView.showErrorMessage("error2")
                    }

                    override fun onFailure(call: Call<UserLoginPOJO>?, t: Throwable?) {
                        loginView.enableLoginButton()
                        loginView.stopLoading()
                        loginView.showErrorMessage("Check your network")
                    }
                })
    }

    override fun emailType(email: String) {
        emailString = email
        checkIfCanLogin()
    }

    override fun passwordType(password: String) {
        passwordString = password
        checkIfCanLogin()
    }

    private fun checkIfCanLogin() {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailString).matches()
        val isPasswordValid = passwordString.length >= PASSWORD_MIN_LENGTH

        if (!isEmailValid) {
            loginView.disablePassword()
            loginView.disableLoginButton()
            return
        }
        if (isEmailValid && !isPasswordValid) {
            loginView.enablePassword()
            loginView.disableLoginButton()
            return
        }
        if (isEmailValid && isPasswordValid) {
            loginView.enablePassword()
            loginView.enableLoginButton()
            return
        }

    }

}