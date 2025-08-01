package com.example.NewsProject.service

import com.example.NewsProject.dao.PostRepository
import com.example.NewsProject.dto.PostCreateDto
import com.example.NewsProject.dto.PostUpdateDto
import com.example.NewsProject.entity.PostEntity
import com.example.NewsProject.response.TopicResponse
import com.example.NewsProject.response.PostResponse
import jakarta.transaction.Transactional
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostServiceImpl(
    private val topicService: TopicServiceImpl,
    private val publisherService: PublisherServiceImpl,
    private val postRepository: PostRepository
) : PostService {
    @Transactional
    override fun createPost(postCreateDto: PostCreateDto, publisherUUID: UUID): PostResponse {
        val topicList = topicService.findByIds(postCreateDto.topicIDList).toMutableList()

        val publisher = publisherService.findById(publisherUUID)

        val post = PostEntity().apply {
            this.title = postCreateDto.title
            this.description = postCreateDto.description
            this.content = postCreateDto.content
            this.topic = topicList
            this.publisher = publisher
        }
        val savedPost = postRepository.save(post)
        return PostResponse(savedPost)
    }

    @Transactional
    override fun findAll(): MutableList<PostResponse> {
        return postRepository.findAll().map { PostResponse(it) }.toMutableList()
    }

    @Transactional
    override fun findById(id: UUID): PostEntity {
        val optionalPost = postRepository.findById(id)
        if (optionalPost.isPresent){
            return optionalPost.get()
        }
        throw BadRequestException("Post with uuid - $id not found")
    }

    @Transactional
    override fun updateById(id: UUID, postUpdateDto: PostUpdateDto): PostResponse {
        val post = findById(id)

        postUpdateDto.title?.let { post.title = it }
        postUpdateDto.description?.let { post.description = it }
        postUpdateDto.content?.let { post.content = it }
        postUpdateDto.topicIDList?.let { post.topic = topicService.findByIds(it).toMutableList() }

        val updated = postRepository.save(post)
        return PostResponse(updated)
    }

    @Transactional
    override fun deleteById(id: UUID){
        postRepository.deleteById(id)
    }

    @Transactional
    override fun findPostsByTopicId(posts: List<PostResponse>, topics: List<TopicResponse>, topicId: Int): List<PostResponse> {
        val topicName: String? = topics.find { it.id == topicId }?.name
        return posts.filter { it.topics.contains<Any?>(topicName) }
    }
}