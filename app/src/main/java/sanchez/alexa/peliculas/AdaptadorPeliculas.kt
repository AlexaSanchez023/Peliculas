package sanchez.alexa.peliculas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorPeliculas: BaseAdapter {
    lateinit var contexto: Context
    var peliculas: ArrayList<Pelicula> = ArrayList()

    constructor(context: Context,peliculas: ArrayList<Pelicula>){
        this.contexto=context
        this.peliculas=peliculas
    }

    override fun getCount(): Int {
        //numero de objetos en la lista
        return peliculas.size
    }

    override fun getItem(position: Int): Any {
        //indica el elemento con el cual puedo interactuar
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        //pide el id del elemento en el que se esta trabajando
            return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //obtener un inflador
        var inflador = LayoutInflater.from(contexto)
        var vista = inflador.inflate(R.layout.pelicula_view, null)
        var img: ImageView= vista.findViewById(R.id.imageView)
        var nom: TextView= vista.findViewById(R.id.nombrePeli)
        var dur: TextView= vista.findViewById(R.id.duracion)
        var peli: Pelicula = peliculas[position]

        img.setImageResource(peli.img)
        nom.setText(peli.nombre)
        dur.setText(peli.dur)

        vista.setOnClickListener {
            val intent: Intent = Intent(contexto, PeliculaActivity::class.java)
            intent.putExtra("imagen",peli.img)
            intent.putExtra("name",peli.nombre)
            intent.putExtra("sinopsis",peli.sinopsis)
            contexto.startActivity(intent)
        }

        return vista
    }


}