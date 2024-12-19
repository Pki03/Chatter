# Chatter

This is a real-time chat application built using Jetpack Compose for the Android UI and Firebase for backend services. Users can send text messages and images, interact with various chat channels, and manage permissions for camera access.

## Table of Contents

- [Getting Started](#getting-started)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [App Structure](#app-structure)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Further Improvements](#further-improvements)

## Getting Started

To get started with this project, follow the steps below to set up the app on your local machine.

### Prerequisites

Ensure that you have the following installed:

- [Android Studio](https://developer.android.com/studio) (or any preferred IDE for Android development)
- [Java JDK 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- A Firebase account for setting up Firebase services like Firebase Realtime Database, Firebase Storage, and Firebase Authentication.

### Setup Instructions

**Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/chat-app.git
   cd chat-app


A simple real-time chat application where users can send text and image messages, manage chat channels, and interact through a dynamic chat interface. Built with Jetpack Compose, Firebase, and Kotlin.

## Features

- **Real-Time Chat**: 
  - Users can send text and image messages in real-time.
  - Messages are stored in Firebase Realtime Database, ensuring real-time updates.
  
- **Image Attachment**: 
  - Users can attach images from their gallery or take new pictures using the camera.
  - The app handles image uploads to Firebase Storage and stores the image URL in the chat message.
  
- **Dynamic Chat Interface**: 
  - The chat screen displays messages in bubbles, with each message showing either text or an image, depending on the message content.
  - The UI automatically updates to show new messages.
  
- **Channel Management**: 
  - Users can view a list of existing channels.
  - A floating action button (FAB) allows users to add new channels by entering a channel name.
  - Channels are fetched from Firebase Realtime Database and updated dynamically.
  
- **Channel Navigation**: 
  - Users can navigate between different channels by clicking on a channel in the list, opening the corresponding chat screen.
  
- **Permissions Management**: 
  - The app requests necessary permissions to access the camera and storage for smooth image selection and capture.

## Technologies Used

- **Jetpack Compose**: UI framework for building the user interface.
- **Firebase Realtime Database**: For storing and syncing chat messages in real-time.
- **Firebase Storage**: For storing and retrieving images sent through the chat.
- **Firebase Authentication**: For authenticating users and associating messages with their accounts.
- **Hilt**: For dependency injection.
- **Kotlin Coroutines & StateFlow**: For managing state and performing asynchronous operations.
- **Jetpack Navigation**: For managing navigation between different screens (e.g., HomeScreen, ChatScreen).

## App Structure

The app is structured into several main components:

- **HomeScreen**: Displays a list of chat channels, allows users to search, and provides a floating action button to create new channels.
- **ChatScreen**: The main chat interface where users can send text and image messages in real-time.
- **ContentSelectionDialog**: A dialog for selecting between using the camera or gallery to choose an image.
- **ChatMessages**: Composable for displaying messages in the chat.
- **ChatBubble**: Displays individual chat messages in a bubble format.
- **ChatViewModel**: Manages chat data, including sending messages, uploading images, and fetching messages.
- **HomeViewModel**: Manages the list of channels and handles the creation of new channels.
