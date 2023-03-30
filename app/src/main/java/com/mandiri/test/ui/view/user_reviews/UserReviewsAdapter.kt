package com.mandiri.test.ui.view.user_reviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.core.utils.ext.safe
import com.mandiri.test.databinding.ItemUserReviewBinding
import com.mandiri.test.domain.remote.model.Review

class UserReviewsAdapter: PagingDataAdapter<Review, UserReviewsAdapter.ViewHolder>(CharacterComparator) {

    inner class ViewHolder(private val binding: ItemUserReviewBinding) : RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun bind(data: Review){
            binding.apply {
                tvName.text = data.author.safe()
                tvRating.text = "Rating: ${data.authorDetails?.rating.safe()}"
                tvReview.text = data.content.safe()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    object CharacterComparator : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Review, newItem: Review) =
            oldItem == newItem
    }
}