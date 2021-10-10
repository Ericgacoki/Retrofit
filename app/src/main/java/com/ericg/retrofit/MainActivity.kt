package com.ericg.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.ericg.retrofit.adapter.PostAdapter
import com.ericg.retrofit.databinding.ActivityMainBinding
import com.ericg.retrofit.model.Post
import com.ericg.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var postAdapter: PostAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        postAdapter = PostAdapter()
        binding.postsRecyclerView.apply {
            adapter = postAdapter
           /* addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )*/
        }
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        val post = Post(1,2, "Eric testing", "Eric was able to test this API")
        viewModel.pushPost(post)

        viewModel.pushPostResponse.observe(this, { response ->
            try {
                if (response.isSuccessful) {
                    // response.body()?.let { postAdapter.putData(it) }
                    Log.d("Post", response.body().toString())
                    Log.d("Post", response.code().toString())
                    Log.d("Post", response.message().toString())
                } else {
                    Log.e("Response", response.errorBody().toString())
                }
            } catch (e: Exception) {
                Log.e("Response", e.toString())
            }
        })
    }
}