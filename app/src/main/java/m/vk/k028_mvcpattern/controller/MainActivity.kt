package m.vk.k028_mvcpattern.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import m.vk.k028_mvcpattern.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameMain, LoginFragment.newInstance())
            .commit()
    }
}
