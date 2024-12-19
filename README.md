# Chatter

This is a sophisticated real-time chat application built with **Jetpack Compose** for creating an intuitive and dynamic Android user interface, and **Firebase** for seamless backend services. The app enables users to send both text and image messages, interact with multiple chat channels, and easily manage camera and storage permissions for image uploads.

## Getting Started

To get started with this project, follow the steps below to set up the app on your local machine.

### Prerequisites

Ensure that you have the following installed:

- [Android Studio](https://developer.android.com/studio) (or any preferred IDE for Android development)
- [Java JDK 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- A Firebase account for setting up Firebase services like Firebase Realtime Database, Firebase Storage, and Firebase Authentication.

###

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

## Features

### ChatScreen Composable:
- **Scaffold Setup**: Provides the main UI layout for the chat interface.
- **ViewModel & State**: Uses `ChatViewModel` to manage state such as dialog visibility and image URI.
- **Launchers**:
  - `cameraImageLauncher`: Launches the camera to capture images.
  - `imageLauncher`: Allows users to select images from the gallery.
  - `permissionLauncher`: Requests camera permissions if not granted yet.
- **Image URI Creation**: Generates a temporary URI for storing captured images.
- **UI Structure**: Displays chat interface with message input and image sending options.
- **Chooser Dialog**: Lets users choose between camera or gallery for image selection.

### ContentSelectionDialog Composable:
- Simple dialog to select between camera or gallery for image picking.

### ChatMessages Composable:
- **Message Display**: Displays chat messages in a `LazyColumn`.
- **Message Input**: Input field for sending text messages.
- **Image Attachment**: Icon to attach images from the gallery or camera.
- **Message Sending**: Sends messages using the `onSendMessage` callback.

### ChatBubble Composable:
- Displays messages in chat bubbles with different styles for the current user and others.
- If the message has an image URL, it shows the image; otherwise, it displays text.

### ChatViewModel:
- **State Management**: Uses `MutableStateFlow` to manage the list of messages.
- **sendMessage()**: Sends text/image messages to Firebase Realtime Database.
- **sendImageMessage()**: Uploads images to Firebase Storage and sends the URL to the database.
- **listenForMessages()**: Listens for incoming messages and updates the UI.
- **registerUserInChannel()**: Adds the user to the channel's user list in Firebase.

### Firebase Integration:
- **Realtime Database**: Stores messages and user data in Firebase Realtime Database.
- **Firebase Storage**: Stores image files uploaded by users.
- **Firebase Authentication**: Uses Firebase Auth to authenticate users and associate messages with the sender.

### Permissions:
- **Camera Permission**: Requests camera permission if not granted already.

---

### HomeScreen Composable:
- **ViewModel & State**: Manages the list of channels using `HomeViewModel` and handles the state for the "Add Channel" dialog.
- **Scaffold**: Structured with a Floating Action Button (FAB) for adding new channels and a search bar (search functionality not yet implemented).
- **Channel List**: Displays existing channels in a `LazyColumn`, each linked to a specific chat screen.
- **Add Channel Dialog**: A bottom sheet dialog for entering the name of a new channel.

### ChannelItem Composable:
- Displays each channel in a rounded box. Clicking on a channel navigates to its respective chat screen.

### AddChannelDialog Composable:
- Provides a `TextField` for entering a new channel name and a button to add the channel.

### HomeViewModel:
- **State Management**: Uses `MutableStateFlow` to manage channels and exposes them as a `StateFlow` for the UI.
- **Fetching Channels**: Retrieves the list of channels from Firebase Realtime Database using the `getChannels()` method.
- **Adding a New Channel**: Adds a new channel to Firebase and refreshes the channel list.

### Firebase Integration:
- **Realtime Database**: Channels are fetched and stored in the Firebase Realtime Database.

### UI Layout and Behavior:
- **FAB**: Positioned at the bottom-right corner to trigger the "Add Channel" process.
- **Modal Bottom Sheet**: Used for adding a new channel through an input dialog.

### Summary:
- **HomeScreen**: Displays a list of channels, allows searching (not yet implemented), and supports creating new channels via a bottom sheet dialog.



### Setup Instructions

**Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/chat-app.git
   cd chatter

