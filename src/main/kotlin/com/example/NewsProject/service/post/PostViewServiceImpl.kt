package com.example.NewsProject.service.post

import com.example.NewsProject.dao.PostRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostViewServiceImpl(
    private val postRepository: PostRepository,
    private val postServiceImpl: PostServiceImpl,
): PostViewService {

    override fun incrementView(id: UUID) {
        val post = postServiceImpl.findById(id)
        post.viewCount = post.viewCount?.plus(1)
        postRepository.save(post)
    }
}