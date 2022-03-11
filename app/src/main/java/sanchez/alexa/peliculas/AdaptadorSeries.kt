package sanchez.alexa.peliculas


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorSeries: BaseAdapter {

    lateinit var contexto: Context
    var series: ArrayList<Serie> = ArrayList()

    constructor(context: Context,series: ArrayList<Serie>){
        this.contexto=context
        this.series=series

    }
    override fun getCount(): Int {
        return series.size
    }

    override fun getItem(position: Int): Any {
        return series[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //obtener un inflador
        var inflador = LayoutInflater.from(contexto)
        var vista = inflador.inflate(R.layout.pelicula_view, null)
        var img: ImageView = vista.findViewById(R.id.imageView)
        var nom: TextView = vista.findViewById(R.id.nombrePeli)
        var temp: TextView = vista.findViewById(R.id.duracion)
        var serie: Serie = series[position]

        img.setImageResource(serie.img)
        nom.setText(serie.nombre)
        temp.setText(serie.temporadas)

        vista.setOnClickListener {
            val intent: Intent = Intent(contexto, PeliculaActivity::class.java)
            intent.putExtra("imagen",serie.img)
            intent.putExtra("name",serie.nombre)
            intent.putExtra("sinopsis",serie.sinopsis)
            contexto.startActivity(intent)
        }

        return vista
    }

}