package ru.netology.netologypost.repository

import androidx.lifecycle.LiveData
import ru.netology.netologypost.Post

    interface PostRepository {
        val data: LiveData<Post>

        fun like()
        fun share()
    }
