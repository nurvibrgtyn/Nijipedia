package com.example.nijipedia

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListNijiAdapter(
    private val listNiji: ArrayList<Niji>,
    ) : RecyclerView.Adapter<ListNijiAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_niji, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (name, photo, description) = listNiji[position]
        holder.tvName.text = name
        holder.imgPhoto.setImageResource(photo)
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {

            val getData = listNiji.get(position)
            val detailPhoto: Int = getData.photo
            val detailName: String = getData.name
            val detailDesc: String = getData.description
            val detailBirthday: String = getData.birthday
            val detailHeight: String = getData.height
            val detailDebut: String = getData.debut
            val detailSong: String = getData.song
            val detailAlbum: Int = getData.album

            val intentToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentToDetail.putExtra("mPhoto", detailPhoto)
            intentToDetail.putExtra("mName", detailName)
            intentToDetail.putExtra("mDesc", detailDesc)
            intentToDetail.putExtra("mBirthday", detailBirthday)
            intentToDetail.putExtra("mHeight", detailHeight)
            intentToDetail.putExtra("mDebut", detailDebut)
            intentToDetail.putExtra("mSong", detailSong)
            intentToDetail.putExtra("mAlbum", detailAlbum)

            holder.itemView.context.startActivity(intentToDetail)
        }
    }

    override fun getItemCount(): Int = listNiji.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface  OnItemClickCallback {
        fun onItemClicked(data: Niji)
    }
}