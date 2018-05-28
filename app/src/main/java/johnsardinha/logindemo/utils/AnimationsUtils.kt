package johnsardinha.logindemo.utils

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

fun View.animateAlpha(from: Float, to: Float, duration: Int) {
    log(String.format("animate alpha from: %s, to: %s", from, to))
    val animation = AlphaAnimation(this.alpha, to)
    animation.duration = duration.toLong()
    animation.fillAfter = true
    animation.fillBefore = true
    this.startAnimation(animation)
}