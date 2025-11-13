# 🗣️ SwarGuru — Bilingual Speech Therapy App (Hindi & English)

## 📖 Overview
**SwarGuru** is a bilingual **speech sound disorder intervention system** developed to assist individuals in improving their articulation in **Hindi** and **English**.  
This project combines a **mobile application (Android)** with a **backend API (Node.js + MongoDB)** to deliver personalized speech therapy sessions with **audio-visual feedback** and **progress tracking**.

---

## 🎯 Key Features

### 👩‍🏫 User Module (Android App)
- 🧾 **Account creation & login** — Secure authentication system.  
- 🎙️ **Speech sound exercises** — Customized Hindi & English sound articulation practices.  
- 🎧 **Audio-visual feedback** — Real-time comparison of user pronunciation with reference sounds.  
- 📊 **Progress tracking** — Tracks improvement and stores session data in **MongoDB**.  

### 🛠️ Admin Module (Web + Backend)
- 👤 **User management** — Add, edit, or delete users and track their progress.  
- 📚 **Therapy content configuration** — Upload and manage video/audio therapy content.  
- 📈 **Performance analytics** — View detailed reports and track therapy effectiveness.  

---

## 🧰 Tech Stack

### 🖥️ **Frontend (Mobile)**
- **Android Studio**  
- **Kotlin + XML** (for UI design)  
- **VideoView** and **RecyclerView** for interactive therapy content  
- **Retrofit** for API integration  

### ⚙️ **Backend**
- **Node.js (Express.js)** — RESTful API  
- **MongoDB + Mongoose** — Database and schema design  
- **bcrypt** — Password hashing and user authentication  

### 🗃️ **Database**
- **MongoDB Compass** for managing collections and data visualization  

---

## 🏗️ Architecture Overview

User (Android App)
│
▼
Retrofit API Calls
│
▼
Node.js Server (Express)
│
▼
MongoDB Database

yaml
Copy code

---

## 📱 Android App Structure

app/
│
├── java/com/example/swarguru/
│ ├── activities/ # Login, Signup, Profile, Change Password
│ ├── adapters/ # RecyclerView & Video Adapters
│ ├── api/ # Retrofit API Interfaces
│ ├── fragments/ # Graph, Therapy, Profile Fragments
│ ├── models/ # Request & Response Data Classes
│ └── utils/ # Shared Preferences, Constants, etc.
│
├── res/layout/ # XML UI layouts
│ ├── activity_login.xml
│ ├── activity_edit_profile.xml
│ ├── fragment_graph.xml
│ └── activity_change_password.xml
│
└── AndroidManifest.xml

yaml
Copy code

---

## 🌐 Backend Overview

backend/
│
├── models/
│ └── User.js # Mongoose schema for users
│
├── controllers/
│ ├── userController.js # Register, login, edit profile, change password
│ ├── videoController.js # Video upload & management
│
├── routes/
│ ├── userRoutes.js
│ └── videoRoutes.js
│
├── config/
│ └── db.js # MongoDB connection setup
│
└── server.js # Entry point

yaml
Copy code

---

## ▶️ How to Run

### 🖥️ 1. Clone Repository
```bash
git clone https://github.com/kadurumahendra/SwarGuru.git
cd SwarGuru
📱 2. Run the Android App
Open the project in Android Studio

Let Gradle sync automatically

Connect your emulator or physical device

Click ▶️ Run

⚙️ 3. Run Backend Server
bash
Copy code
cd backend
npm install
node server.js
📊 Features Summary
Module	Technologies	Description
User App (Android)	Kotlin, XML, Retrofit	Bilingual therapy app with speech feedback and progress tracking
Backend API	Node.js, Express, MongoDB	Handles user data, therapy content, and authentication
Database	MongoDB Compass	Stores users, sessions, and therapy progress
Admin Panel	Node.js Views / API	Manage users and therapy videos

📘 Learning Outcomes
Built a real-world bilingual therapy app integrating frontend and backend.

Understood RESTful API integration using Retrofit in Android.

Implemented secure login and data storage using MongoDB and bcrypt.

Strengthened understanding of Kotlin Android development and Node.js API design.

🧑‍💻 Author
Kaduru Mahendra
🎓 B.E. Computer Science Engineer
💻 Passionate about Android & Backend Development
📍 Tirupati, India
🔗 GitHub Profile

“Learning Spring and building real-world Android apps helps bridge the gap between theory and professional development.”
