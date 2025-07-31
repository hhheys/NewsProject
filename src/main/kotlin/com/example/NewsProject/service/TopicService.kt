package com.example.NewsProject.service

import com.example.NewsProject.entity.TopicEntity

interface TopicService {
    fun findById(id: Int): TopicEntity

    fun findByIds(idList: List<Int>): List<TopicEntity>
}