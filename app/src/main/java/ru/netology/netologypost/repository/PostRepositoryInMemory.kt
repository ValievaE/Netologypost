package ru.netology.netologypost.repository



import ru.netology.netologypost.Post
import androidx.lifecycle.MutableLiveData



class PostRepositoryInMemory: PostRepository {

    private var post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен",
            published = "21 мая в 18:36",
            liked = false,
            shared = false,
            likesCount = 999,
            sharesCount = 9999
    )

    override val data = MutableLiveData(post)

    override fun like() {
        val currentPost = requireNotNull(data.value)
        data.value = currentPost.copy(liked = true, likesCount = currentPost.likesCount.inc())
    }

    override fun share() {
        val currentPost = requireNotNull(data.value)
        data.value = currentPost.copy(shared = true, sharesCount = currentPost.sharesCount.inc())

    }
}