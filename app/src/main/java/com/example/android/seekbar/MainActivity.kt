package com.example.android.seekbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = text_view_progress.translationY

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                text_view_progress.text = progress.toString()

                val animstep = resources.getDimension(R.dimen.text_anim_step)
                val translationDistance = (initialTextViewTranslationY + progress * animstep * -1)

                text_view_progress.animate().translationY(translationDistance)

                if (!fromUser) {
                    text_view_progress
                        .animate()
                        .setDuration(500)
                        .rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        button.setOnClickListener { v ->
            seek_bar.progress = 0
        }

    }
}

