package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController // Descomenta cuando tengas las rutas

class LateralMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lateral_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnEpisodios = view.findViewById<TextView>(R.id.tv_episodios)
        val btnEstadisticas = view.findViewById<TextView>(R.id.tv_estadisticas)
        val btnAjustes = view.findViewById<TextView>(R.id.tv_ajustes)
        val btnAcercaDe = view.findViewById<TextView>(R.id.tv_acerca_de)



        btnEpisodios.setOnClickListener {
            Toast.makeText(context, getString(R.string.ir_a_episodios), Toast.LENGTH_SHORT).show()
            // findNavController().navigate(R.id.action_lateral_to_episodios)
        }

        btnEstadisticas.setOnClickListener {
            Toast.makeText(context, getString(R.string.ir_a_estad_sticas), Toast.LENGTH_SHORT).show()
            // findNavController().navigate(R.id.action_lateral_to_estadisticas)
        }

        btnAjustes.setOnClickListener {

            Toast.makeText(context, "Ir a Ajustes", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.settings)
        }

        btnAcercaDe.setOnClickListener {

            val versionName = "1.0.0"

            // Construir el diálogo
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.about_menu_name)) // Título de la ventana
                .setMessage(getString(R.string.about, versionName)) // El contenido
                .setPositiveButton("Aceptar") { dialog, _ ->
                    dialog.dismiss() // Cierra el diálogo al pulsar
                }
                .create()
                .show()
        }
    }
}