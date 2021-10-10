package com.ericg.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericg.retrofit.databinding.PostViewBinding
import com.ericg.retrofit.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var posts = listOf<Post>()

    inner class PostViewHolder(private val postView: PostViewBinding) : RecyclerView.ViewHolder(postView.root){
        fun bind(post: Post){
            postView.title.text = post.title
            postView.postId.text = post.id.toString()
            postView.postBody.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(post = posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun putData(postsList: List<Post>) {
        posts = postsList
        notifyDataSetChanged()
    }
}