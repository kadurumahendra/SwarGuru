package com.example.swarguru.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.swarguru.R
import com.squareup.picasso.Picasso

class LettersAdapter(var letters:ArrayList<Int>,var context:Context):RecyclerView.Adapter<LettersAdapter.LettersViewHolder>() {

    // Boolean flag to determine whether to show lockIcon//
//    private var showLockIcon = true
//
//    fun setShowLockIcon(showLockIcon: Boolean) {
//        this.showLockIcon = showLockIcon
//        notifyDataSetChanged()
//    }
    class LettersViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val letterIV:ImageView = view.findViewById(R.id.letterIV)
        val lockIcon:ImageView = view.findViewById(R.id.lockIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LettersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_layout,parent,false)
        return LettersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return letters.size
    }

    override fun onBindViewHolder(holder: LettersViewHolder, position: Int) {
        val letter = letters[position]
        Picasso.get().load(letter).into(holder.letterIV)
//        // Show or hide lockIcon based on the position
//        if (position == 0 && !showLockIcon) {
//            holder.lockIcon.visibility = View.GONE
//        } else {
//            holder.lockIcon.visibility = View.VISIBLE
//        }
    }
}