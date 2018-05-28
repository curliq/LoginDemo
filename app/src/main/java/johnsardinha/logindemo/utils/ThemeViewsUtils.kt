package johnsardinha.logindemo.utils

import android.support.v4.content.ContextCompat
import android.widget.EditText
import johnsardinha.logindemo.R

object ThemeEditTextUtils {

    fun EditText.enableEditText() {
        this.isEnabled = true
        this.setTextColor(ContextCompat.getColor(this.context, R.color.themeEditTextEnabledText))
        this.setHintTextColor(ContextCompat.getColor(this.context, R.color.themeEditTextEnabledHint))
    }

    fun EditText.disableEditText() {
        this.isEnabled = false
        this.setTextColor(ContextCompat.getColor(this.context, R.color.themeEditTextDisabledText))
        this.setHintTextColor(ContextCompat.getColor(this.context, R.color.themeEditTextDisabledHint))
    }

}
