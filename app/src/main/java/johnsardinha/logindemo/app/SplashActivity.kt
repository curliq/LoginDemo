package johnsardinha.logindemo.app

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import johnsardinha.logindemo.app.login.LogInActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LogInActivity::class.java))
    }
}