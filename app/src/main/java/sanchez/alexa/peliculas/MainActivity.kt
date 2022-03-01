package sanchez.alexa.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var peliculas: ArrayList<Pelicula> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llenarPeliculas()

        var adaptador = AdaptadorPeliculas(this, peliculas)
        var listView: ListView = findViewById(R.id.listview)
        listView.adapter = adaptador
    }

    fun llenarPeliculas(){
        val pelicula1 = Pelicula(1,getString(R.string.pelicula1),getString(R.string.pelicula1_desc),getString(R.string.duracion1),R.drawable.aladin)
        val pelicula2 = Pelicula(2,getString(R.string.pelicula2),getString(R.string.pelicula2_desc),getString(R.string.duracion2),R.drawable.malefica)
        val pelicula3 = Pelicula(3,getString(R.string.pelicula3),getString(R.string.pelicula3_desc),getString(R.string.duracion3),R.drawable.ratatouille)
        val pelicula4 = Pelicula(4,getString(R.string.pelicula4),getString(R.string.pelicula4_desc),getString(R.string.duracion4),R.drawable.sherk)
        val pelicula5 = Pelicula(5,getString(R.string.pelicula5),getString(R.string.pelicula5_desc),getString(R.string.duracion5),R.drawable.titanic)
        peliculas.add(pelicula1)
        peliculas.add(pelicula2)
        peliculas.add(pelicula3)
        peliculas.add(pelicula4)
        peliculas.add(pelicula5)
    }
}