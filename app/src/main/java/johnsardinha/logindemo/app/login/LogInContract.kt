package johnsardinha.logindemo.app.login

import johnsardinha.logindemo.utils.base.BasePresenter
import johnsardinha.logindemo.utils.base.BaseView

interface LogInContract {

    interface View : BaseView<Presenter> {

        fun enablePassword()

        fun disablePassword()

        fun enableLoginButton()

        fun disableLoginButton()

        fun startLoading()

        fun stopLoading()

        fun showErrorMessage(message: String)

        fun successfullyLoggedIn()
    }

    interface Presenter : BasePresenter {

        fun emailType(email: String)

        fun passwordType(password: String)

        fun login(email: String, password: String)
    }
}