package id.mohekkus.modularjunkie

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitcompat.SplitCompatApplication

class SighApplication: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}