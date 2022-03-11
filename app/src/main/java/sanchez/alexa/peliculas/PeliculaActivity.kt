package sanchez.alexa.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PeliculaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)
        val tv_nombre: TextView = findViewById(R.id.titulo_pelicula)
        var tv_desc: TextView = findViewById(R.id.desc_pelicula)
        val tv_img: ImageView = findViewById(R.id.img_pelicula)

        val bundle = intent.extras

        if (bundle != null){
            var nombre: String = bundle.getString("name", "")
            var sinopsis: String=bundle.getString("sinopsis","")
            var image: Int = bundle.getInt("imagen",)

            tv_nombre.setText(nombre)
            tv_desc.setText(sinopsis)
            tv_img.setImageResource(image)
        }
    }
}