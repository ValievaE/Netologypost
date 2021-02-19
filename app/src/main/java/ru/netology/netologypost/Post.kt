package ru.netology.netologypost

data class Post(
        val id: Long,
        val author: String,
        val content: String,
        val published: String,
        val liked: Boolean = false,
        val shared: Boolean,
        val likesCount: Int = 0,
        val sharesCount: Int = 0,
)

