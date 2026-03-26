package com.azelera.tv

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide // Librería recomendada para imágenes

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var imageView: ImageView
    private lateinit var textContainer: LinearLayout
    private lateinit var txtAd: TextView
    private lateinit var layoutWelcome: View
    private lateinit var uiCountdown: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        videoView = findViewById(R.id.videoPlayer)
        imageView = findViewById(R.id.imgPlayer)
        textContainer = findViewById(R.id.textContainer)
        txtAd = findViewById(R.id.txtAd)
        layoutWelcome = findViewById(R.id.layoutWelcome)
        uiCountdown = findViewById(R.id.uiCountdown)

        findViewById<Button>(R.id.btnActivar).setOnClickListener {
            obtenerAnuncioDelDashboard()
        }
    }

    private fun obtenerAnuncioDelDashboard() {
        layoutWelcome.visibility = View.GONE
        
        // SIMULACIÓN DE DATOS DEL DASHBOARD
        // El dashboard enviará un "tipo" (VIDEO, IMAGE, TEXT) y el "contenido"
        val tipoAnuncio = "IMAGE" // Esto vendría de tu API
        val contenido = "https://tu-servidor.com/oferta_del_dia.jpg"

        when (tipoAnuncio) {
            "VIDEO" -> mostrarVideo(contenido)
            "IMAGE" -> mostrarImagen(contenido)
            "TEXT" -> mostrarTexto("¡LIQUIDACIÓN TOTAL! \n 70% OFF EN TODA LA TIENDA")
        }
    }

    private fun mostrarVideo(url: String) {
        videoView.visibility = View.VISIBLE
        videoView.setVideoURI(Uri.parse(url))
        videoView.setOnPreparedListener { it.isLooping = true; videoView.start() }
    }

    private fun mostrarImagen(url: String) {
        imageView.visibility = View.VISIBLE
        // Usamos Glide para cargar la imagen de internet eficientemente
        Glide.with(this).load(url).into(imageView)
    }

    private fun mostrarTexto(mensaje: String) {
        textContainer.visibility = View.VISIBLE
        txtAd.text = mensaje
        // Podrías poner un fondo de color aleatorio para llamar la atención
        textContainer.setBackgroundColor(android.graphics.Color.parseColor("#DC2626")) // Rojo intenso
    }
}
