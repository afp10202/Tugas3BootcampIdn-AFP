package com.bootcamp.tugas3_bootcampidn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.tugas3_bootcampidn.ArticlesItem
import com.bootcamp.tugas3_bootcampidn.News
import com.bootcamp.tugas3_bootcampidn.R
import com.bootcamp.tugas3_bootcampidn.databinding.ItemRowNewsBinding
import com.bumptech.glide.Glide

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList: List<ArticlesItem> = listOf()

    inner class NewsViewHolder(private val binding: ItemRowNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ArticlesItem) {
            binding.apply {

                Glide.with(imgNews)
                    .load(data.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgNews)

                tvJudul.text = data.title
                tvPenulis.text = data.author
                tvTanggalPosting.text = data.publishedAt
                binding.cardNews.setOnClickListener {
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = ItemRowNewsBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(newsList[position])
    }

    fun setData(data: List<ArticlesItem>){
        newsList = data
        notifyDataSetChanged()
    }
}