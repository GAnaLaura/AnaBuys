package com.example.anabuys.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.anabuys.R
import com.bumptech.glide.Glide
import com.example.anabuys.databinding.ItemForecastBinding
import com.example.anabuys.model.Forecast
import java.util.Locale

/**
 * Adapter para mostrar el pronóstico diario en un RecyclerView.
 */
class ForecastAdapter : ListAdapter<Forecast, ForecastAdapter.ForecastVH>(ForecastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastVH {
        val binding = ItemForecastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ForecastVH(binding)
    }

    override fun onBindViewHolder(holder: ForecastVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ForecastVH(private val binding: ItemForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Forecast) {
            // Capitaliza nombre de día
            binding.tvDay.text = item.dia.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
            // Muestra temperaturas mín / máx
            binding.tvTemp.text = "${item.temperaturaMin}° / ${item.temperaturaMax}°"
            // Carga icono usando Glide
            Glide.with(binding.imgIcon.context)
                .load("https:${item.icono}")
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imgIcon)
        }
    }

    private class ForecastDiffCallback : DiffUtil.ItemCallback<Forecast>() {
        override fun areItemsTheSame(old: Forecast, new: Forecast) = old.dia == new.dia
        override fun areContentsTheSame(old: Forecast, new: Forecast) = old == new
    }
}
