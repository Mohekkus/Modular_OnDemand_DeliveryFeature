package id.mohekkus.modularjunkie

import android.content.Context
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

class DynFeatHelper(
    private val context: Context
) {

    interface SplitCallback {
        fun onSuccess()
        fun onError()
    }

    enum class SplitIterator {
        DYNAMICFEATURE {
            override fun named(): String {
                return this.name.lowercase()
            }
        };

        abstract fun named(): String
    }

    private val manager = SplitInstallManagerFactory.create(context)
    private lateinit var callback: SplitCallback

    fun splitInstallRequest(callback: SplitCallback) {
        this.callback = callback

        val request = SplitInstallRequest
            .newBuilder()
            .addModule(SplitIterator.DYNAMICFEATURE.named())
            .build()

        splitInstallManager(request)
    }

    private fun splitInstallManager(request: SplitInstallRequest) {
        manager
            .startInstall(request)
            .addOnSuccessListener {
                callback.onSuccess()
            }
            .addOnFailureListener {
                callback.onError()
            }
    }
}