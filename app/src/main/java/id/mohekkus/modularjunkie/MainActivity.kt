package id.mohekkus.modularjunkie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import id.mohekkus.modularjunkie.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(), DynFeatHelper.SplitCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var helper: DynFeatHelper

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        helper = DynFeatHelper(this)
        setContentView(
            binding.root
        )
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            button.setOnClickListener {
                helper.splitInstallRequest(this@MainActivity)
            }
        }
    }

    override fun onSuccess() {
        startActivity(
            Intent()
                .setClassName("id.mohekkus.modularjunkie", "id.mohekkus.dynamicfeature.DynFeat")
        )
    }

    override fun onError() {
        Toast.makeText(this, "Fuck off", Toast.LENGTH_LONG).show()
    }
}