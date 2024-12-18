package com.prateek.chatter.model

data class Message(
    val id: String = "",
    val senderId: String = "",
    val senderName: String = "",
    val message: String? = null,
    val imageUrl: String? = null,
    val createdAt: Long = 0
)
