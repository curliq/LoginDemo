package johnsardinha.logindemo.app.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import johnsardinha.logindemo.R
import johnsardinha.logindemo.app.main.MainActivity
import johnsardinha.logindemo.utils.ThemeEditTextUtils.disableEditText
import johnsardinha.logindemo.utils.ThemeEditTextUtils.enableEditText
import johnsardinha.logindemo.utils.afterTextChanged
import johnsardinha.logindemo.utils.customviews.ThemeLoadingButton

class LogInFragment : Fragment(), LogInContract.View {

    @BindView(R.id.loginFragment_et_email)
    lateinit var etEmail: EditText
    @BindView(R.id.loginFragment_et_password)
    lateinit var etPassword: EditText
    @BindView(R.id.loginFragment_btn_login)
    lateinit var btnLogIn: ThemeLoadingButton

    override lateinit var presenter: LogInContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        ButterKnife.bind(this, view)
        presenter.start()

        etEmail.afterTextChanged {
            presenter.emailType(it)
        }

        etPassword.afterTextChanged {
            presenter.passwordType(it)
        }

        btnLogIn.setOnClickListener {
            presenter.login(etEmail.text.toString(), etPassword.text.toString())
        }

        return view
    }

    override fun enablePassword() {
        if (!etPassword.isEnabled)
            etPassword.enableEditText()
    }

    override fun disablePassword() {
        if (etPassword.isEnabled)
            etPassword.disableEditText()
    }

    override fun enableLoginButton() {
        if (!btnLogIn.isEnabled)
            btnLogIn.isEnabled = true
    }

    override fun disableLoginButton() {
        if (btnLogIn.isEnabled)
            btnLogIn.isEnabled = false
    }

    override fun startLoading() {
        btnLogIn.showLoading()
    }

    override fun stopLoading() {
        btnLogIn.hideLoading()
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun successfullyLoggedIn() {
        startActivity(Intent(context, MainActivity::class.java))
    }
}