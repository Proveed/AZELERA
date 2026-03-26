package com.azelera.tv

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var layoutWelcome: LinearLayout
    private lateinit var btnActivar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoPlayer)
        layoutWelcome = findViewById(R.id.layoutWelcome)
        btnActivar = findViewById(R.id.btnActivar)

        // ACTIVACIÓN POR CLIC (Desde el botón o el mando)
        btnActivar.setOnClickListener {
            activarPantallaPublicitaria()
        }
    }

    private fun activarPantallaPublicitaria() {
        // Ocultamos la bienvenida y mostramos el video
        layoutWelcome.visibility = View.GONE
        videoView.visibility = View.VISIBLE

        // CONEXIÓN EN TIEMPO REAL
        // Aquí la app jala el video que el anunciante puso en el dashboard
        val urlVideoRealTime = "https://tu-servidor.com/video_actual.mp4" 
        
        videoView.setVideoURI(Uri.parse(urlVideoRealTime))
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true // Reproducción infinita
            videoView.start()
        }
        
        // El sonido se activa automáticamente al dar play
    }
}
