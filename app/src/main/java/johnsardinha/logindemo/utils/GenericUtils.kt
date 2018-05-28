package johnsardinha.logindemo.utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText


const val LOG_TAG: String = "tagg"
const val PASSWORD_MIN_LENGTH = 6

/**
 * Log a message in the console
 *
 * @param message the object to be logged
 */
fun log(message: Any?) {
    Log.i(LOG_TAG, message.toString())
}

/**
 * Listen to text changed on an EditText
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}


