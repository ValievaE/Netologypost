package ru.netology.netologypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.netologypost.databinding.ActivityMainBinding
import ru.netology.netologypost.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()

        with(binding) {
            likes?.setOnClickListener {
                viewModel.like()
            }
            ivShare?.setOnClickListener {
                viewModel.share()
            }
            viewModel.data.observe(this@MainActivity) { post ->
                textViewTitle.text = post.author
                textViewDate.text = post.published
                text.text = post.content
                textViewLikes.text = Converter.convert(post.likesCount)
                textViewShare.text = Converter.convert(post.sharesCount)
                likes.setImageResource(
                        if (post.liked) R.drawable.ic_baseline_favorite_24
                        else R.drawable.ic_baseline_favorite_border_24
                )
            }
        }

    }
}