package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea3_manjoncarrascojosecarlos.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private val episodeViewModel: EpisodeViewModel by viewModels()

    private lateinit var adapter: EpisodeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gestión de márgenes (SystemBars)
        ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Inicializar RecyclerView (Antes de observar nada)
        initRecyclerView()

        // 2. Observar los cambios en la lista
        episodeViewModel.episodes.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                adapter.updateList(list)
            }
        }

        // 3. CORRECCIÓN: Llamar a la función para descargar los datos

        episodeViewModel.loadEPisodes()
    }

    private fun initRecyclerView() {
        // CORRECCIÓN: Instanciamos la clase 'EpisodeAdapter', NO el viewModel
        adapter = EpisodeAdapter(emptyList())

        // Configuración visual
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}