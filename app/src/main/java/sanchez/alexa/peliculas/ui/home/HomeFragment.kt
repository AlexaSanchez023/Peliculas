package sanchez.alexa.peliculas.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sanchez.alexa.peliculas.AdaptadorPeliculas
import sanchez.alexa.peliculas.Pelicula
import sanchez.alexa.peliculas.R
import sanchez.alexa.peliculas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var peliculas: ArrayList<Pelicula> = ArrayList();
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
       // homeViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
       // }

        llenarPeliculas()

        var adaptador = AdaptadorPeliculas(root.context, peliculas)
        var listView: ListView = binding.listPeliculas
        listView.adapter = adaptador

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun llenarPeliculas(){
        val pelicula1 = Pelicula(1,getString(R.string.pelicula1),getString(R.string.pelicula1_desc),getString(
            R.string.duracion1),
            R.drawable.aladin)
        val pelicula2 = Pelicula(2,getString(R.string.pelicula2),getString(R.string.pelicula2_desc),getString(
            R.string.duracion2),
            R.drawable.malefica)
        val pelicula3 = Pelicula(3,getString(R.string.pelicula3),getString(R.string.pelicula3_desc),getString(
            R.string.duracion3),
            R.drawable.ratatouille)
        val pelicula4 = Pelicula(4,getString(R.string.pelicula4),getString(R.string.pelicula4_desc),getString(
            R.string.duracion4),
            R.drawable.sherk)
        val pelicula5 = Pelicula(5,getString(R.string.pelicula5),getString(R.string.pelicula5_desc),getString(
            R.string.duracion5),
            R.drawable.titanic)
        peliculas.add(pelicula1)
        peliculas.add(pelicula2)
        peliculas.add(pelicula3)
        peliculas.add(pelicula4)
        peliculas.add(pelicula5)
    }

}