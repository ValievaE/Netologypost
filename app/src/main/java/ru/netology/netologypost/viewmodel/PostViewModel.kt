package ru.netology.netologypost.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.netology.netologypost.Post
import ru.netology.netologypost.repository.PostRepositoryInMemory

class PostViewModel: ViewModel() {
    private val repository = PostRepositoryInMemory()
    val data: LiveData<Post>
    get() = repository.data
    fun like() = repository.like()
    fun share() = repository.share()
}