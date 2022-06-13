package com.example.materialdesign.view

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.materialdesign.R
import com.example.materialdesign.second_fragment.MenuFragment
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    var music = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, MenuFragment.newInstance()).commit()


        }



    }

    override fun onResume() {
        super.onResume()
        val mediaPlayer = MediaPlayer.create(this, R.raw.track_two)
        music = mediaPlayer
        music.start()
    }

    override fun onStop() {
        super.onStop()
        music.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        music.stop()
    }

}
