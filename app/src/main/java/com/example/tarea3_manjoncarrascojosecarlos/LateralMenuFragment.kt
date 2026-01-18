package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
// import androidx.navigation.fragment.findNavController // Descomenta cuando tengas las rutas

class LateralMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lateral_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Referencias a los textos
        val btnEpisodios = view.findViewById<TextView>(R.id.tv_episodios)
        val btnEstadisticas = view.findViewById<TextView>(R.id.tv_estadisticas)
        val btnAjustes = view.findViewById<TextView>(R.id.tv_ajustes)
        val btnAcercaDe = view.findViewById<TextView>(R.id.tv_acerca_de)

        // 2. Configurar los clics

        btnEpisodios.setOnClickListener {
            Toast.makeText(context, "Ir a Episodios", Toast.LENGTH_SHORT).show()
            // findNavController().navigate(R.id.action_lateral_to_episodios)
        }

        btnEstadisticas.setOnClickListener {
            Toast.makeText(context, "Ir a Estadísticas", Toast.LENGTH_SHORT).show()
            // findNavController().navigate(R.id.action_lateral_to_estadisticas)
        }

        btnAjustes.setOnClickListener {
            // Como Ajustes ya lo tenías en el nav_graph, este sí podríamos probarlo si quisieras
            Toast.makeText(context, "Ir a Ajustes", Toast.LENGTH_SHORT).show()
          //  findNavController().navigate(R.id.action_lateralMenuFragment_to_settings2)
        }

        btnAcercaDe.setOnClickListener {
            Toast.makeText(context, "Ir a Acerca de", Toast.LENGTH_SHORT).show()
        }
    }
}