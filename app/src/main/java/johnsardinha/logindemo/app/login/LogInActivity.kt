package johnsardinha.logindemo.app.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import johnsardinha.logindemo.R
import johnsardinha.logindemo.utils.replaceFragmentInActivity

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val taskDetailFragment = LogInFragment().also {
            replaceFragmentInActivity(supportFragmentManager, it, R.id.loginActivity_container)
        }

        LogInPresenter(taskDetailFragment)
    }

}
