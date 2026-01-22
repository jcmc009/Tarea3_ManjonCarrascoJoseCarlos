package com.example.tarea3_manjoncarrascojosecarlos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea3_manjoncarrascojosecarlos.data.model.Episode
import com.example.tarea3_manjoncarrascojosecarlos.databinding.ItemEpisodeBinding

class EpisodeAdapter(
    private var episodes: List<Episode> // La lista de datos
) : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    // 1. CREAR LA VISTA (Inflar el layout item_episode.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        // "ItemEpisodeBinding" se genera automáticamente si tu XML se llama "item_episode.xml"
        val binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    // 2. RELLENAR LOS DATOS (Poner texto e imagen en cada hueco)
    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val item = episodes[position]
        holder.bind(item)
    }

    // 3. CONTAR ELEMENTOS
    override fun getItemCount(): Int = episodes.size

    // 4. ACTUALIZAR LISTA (Para cuando llegan datos de Internet)
    fun updateList(newList: List<Episode>) {
        episodes = newList
        notifyDataSetChanged()
    }

    class EpisodeViewHolder(val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: Episode) {
            // Asignamos los textos usando los IDs de tu XML anterior
            binding.tvName.text = episode.name
            binding.tvEpisodeCode.text = episode.episode
            binding.tvAirDate.text = episode.air_date
        }
    }
}