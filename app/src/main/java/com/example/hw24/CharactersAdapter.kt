package com.example.hw24

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.hw24.databinding.ItemCharactersBinding

class CharactersAdapter(private val charactersList: ArrayList<Characters>, private val onClick: (Characters) -> Unit) :
    Adapter<CharactersAdapter.CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) : ViewHolder(binding.root) {
        fun bind(characters:Characters) {
            binding.tvName.text = characters.name
            binding.tvState.text = characters.state
            Glide.with(binding.imgPhotoCharacter).load(characters.image).into(binding.imgPhotoCharacter)

            itemView.setOnClickListener {
                onClick(characters)
            }
        }

    }
}
