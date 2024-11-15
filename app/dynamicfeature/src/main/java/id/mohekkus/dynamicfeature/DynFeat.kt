package id.mohekkus.dynamicfeature

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import id.mohekkus.modularjunkie.databinding.ActivityMainBinding


class DynFeat: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(
            binding.root
        )
    }

    override fun onResume() {
        super.onResume()
        binding.button.setOnClickListener {
            Toast.makeText(this, "hello from another module", Toast.LENGTH_LONG).show()
        }
    }
}