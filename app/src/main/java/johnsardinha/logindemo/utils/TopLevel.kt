package johnsardinha.logindemo.utils

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

fun replaceFragmentInActivity(fragmentManager: FragmentManager, fragment: Fragment, @IdRes containerId: Int) {
    fragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
}
