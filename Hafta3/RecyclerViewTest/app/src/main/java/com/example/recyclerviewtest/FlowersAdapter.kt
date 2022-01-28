package com.example.recyclerviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.flow

class FlowersAdapter(var mContext: Context, var flowersList: List<Flowers>) :
    RecyclerView.Adapter<FlowersAdapter.CardDesignContainer>() {
    inner class CardDesignContainer(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewFlower: ImageView
        var textViewTitle: TextView
        var textViewFastDelivery: TextView
        var textViewPrice: TextView
        var ratingBarFlower: RatingBar
        var textViewVoteCount: TextView
        var buttonSimilar: MaterialButton
        var textViewInstalment: TextView

        init {
            imageViewFlower = view.findViewById(R.id.imageViewFlower)
            textViewTitle = view.findViewById(R.id.textViewTitle)
            textViewFastDelivery = view.findViewById(R.id.textViewFastDelivery)
            textViewPrice = view.findViewById(R.id.textViewPrice)
            ratingBarFlower = view.findViewById(R.id.ratingBarFlower)
            textViewVoteCount = view.findViewById(R.id.textViewVoteCount)
            buttonSimilar = view.findViewById(R.id.buttonSimilar)
            textViewInstalment = view.findViewById(R.id.textViewInstalment)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignContainer {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design, parent, false)
        return CardDesignContainer(design)
    }

    override fun onBindViewHolder(holder: CardDesignContainer, position: Int) {
        val flower = flowersList.get(position)

        holder.imageViewFlower.setImageResource(
            mContext.resources.getIdentifier(
                flower.img,
                "drawable",
                mContext.packageName
            )
        )

        holder.textViewTitle.text = flower.title

        holder.textViewPrice.text = "${flower.price} ₺"

        holder.ratingBarFlower.rating = flower.rating

        holder.textViewVoteCount.text = "(999+)" // TODO: Implement it with databinding

        holder.buttonSimilar.setOnClickListener {
            Snackbar.make(it, "Benzer Ürünler Yakında Sizlerle!", Snackbar.LENGTH_SHORT).show()
        }

        holder.textViewInstalment.text = "${flower.instalment} ₺'den Başlayan Taksitlerle"
    }

    override fun getItemCount(): Int {
        return flowersList.size
    }
}