package johnsardinha.logindemo.utils.customviews

import android.animation.AnimatorInflater
import android.animation.StateListAnimator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.wang.avi.AVLoadingIndicatorView
import johnsardinha.logindemo.R

class ThemeLoadingButton : RelativeLayout {

    lateinit var loadingIndicator: AVLoadingIndicatorView
    lateinit var textView: TextView
    private var attrs: AttributeSet? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.attrs = attrs
        init()
    }

    private fun init() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.loading_button_view, this)

        loadingIndicator = findViewById(R.id.loadingButton_pb)
        textView = findViewById(R.id.loadingButton_tv)

        setAttrs()
    }

    private fun setAttrs() {
        setBackgroundResource(R.drawable.theme_button_background)
        stateListAnimator = AnimatorInflater.loadStateListAnimator(context, R.drawable.theme_button_state_animator)
        loadingIndicator.hide()

        if (attrs != null) {
            val a = context.theme.obtainStyledAttributes(attrs, R.styleable.ThemeLoadingButton, 0, 0)
            setText(a.getString(R.styleable.ThemeLoadingButton_text))
        }
    }

    public fun showLoading() {
        loadingIndicator.smoothToShow()
    }

    public fun hideLoading() {
        loadingIndicator.smoothToHide()
    }

    public fun setTextColor(color: Int) {
        textView.setTextColor(color)
    }

    public fun setText(text: String) {
        textView.setText(text)
    }
}