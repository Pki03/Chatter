package com.prateek.chatter.feature.chat

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.prateek.chatter.model.Message
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.firebase.database.ktx.database
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(@ApplicationContext private val context: Context) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages = _messages.asStateFlow()
    private val db = Firebase.database

    fun sendMessage(channelID: String, messageText: String?, imageUrl: String? = null) {
        val message = Message(
            id = db.reference.push().key ?: UUID.randomUUID().toString(),
            senderId = Firebase.auth.currentUser?.uid ?: "",
            message = messageText,
            createdAt = System.currentTimeMillis(),
            senderName = Firebase.auth.currentUser?.displayName ?: "",
            imageUrl = imageUrl
        )

        db.reference.child("messages").child(channelID).push().setValue(message)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.e("ChatViewModel", "Error sending message: ${task.exception}")
                }
            }
    }

    fun sendImageMessage(uri: Uri, channelID: String) {
        val storageRef = Firebase.storage.reference.child("images/${UUID.randomUUID()}")
        storageRef.putFile(uri).continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let { throw it }
            }
            storageRef.downloadUrl
        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result.toString()
                sendMessage(channelID, null, downloadUri)
            } else {
                Log.e("ChatViewModel", "Error uploading image: ${task.exception}")
            }
        }
    }

    fun listenForMessages(channelID: String) {
        db.getReference("messages").child(channelID).orderByChild("createdAt")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val messages = snapshot.children.mapNotNull { it.getValue(Message::class.java) }
                    _messages.value = messages
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("ChatViewModel", "Failed to load messages: ${error.message}")
                }
            })
        registerUserInChannel(channelID)
    }

    private fun registerUserInChannel(channelID: String) {
        val currentUser = Firebase.auth.currentUser ?: return
        val channelUsersRef = db.reference.child("channels").child(channelID).child("users")
        channelUsersRef.child(currentUser.uid).setValue(currentUser.email)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.e("ChatViewModel", "Failed to register user in channel: ${task.exception}")
                }
            }
    }
}
