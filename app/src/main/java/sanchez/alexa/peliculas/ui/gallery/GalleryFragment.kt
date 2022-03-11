package sanchez.alexa.peliculas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sanchez.alexa.peliculas.AdaptadorSeries
import sanchez.alexa.peliculas.R
import sanchez.alexa.peliculas.Serie
import sanchez.alexa.peliculas.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    var series: ArrayList<Serie> = ArrayList();
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

       // val textView: TextView = binding.textGallery
        //galleryViewModel.text.observe(viewLifecycleOwner) {
          //  textView.text = it
        //}
        llenarSeries()
        var adaptador = AdaptadorSeries(root.context,series)
        var listView: ListView = binding.listSeries
        listView.adapter = adaptador

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarSeries(){

        val serie1 = Serie(1,getString(R.string.serie1),getString(R.string.sinopsis1),getString(R.string.temporadas1),R.drawable.outlander )
        val serie2 = Serie(2,getString(R.string.serie2),getString(R.string.sinopsis2),getString(R.string.temporadas2),R.drawable.got )
        val serie3 = Serie(3,getString(R.string.serie3),getString(R.string.sinopsis3),getString(R.string.temporadas3),R.drawable.dark )
        val serie4 = Serie(4,getString(R.string.serie4),getString(R.string.sinopsis4),getString(R.string.temporadas4),R.drawable.euphoria )
        val serie5 = Serie(5,getString(R.string.serie5),getString(R.string.sinopsis5),getString(R.string.temporadas5),R.drawable.one_piece )

        series.add(serie1)
        series.add(serie2)
        series.add(serie3)
        series.add(serie4)
        series.add(serie5)
    }
}