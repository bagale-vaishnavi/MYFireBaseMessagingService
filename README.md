# Firebase Push App

## Setup

1. Place `MyFirebaseMessagingService.java` under:
   `android/app/src/main/java/com/notificationapp/`
2. Add Firebase dependencies and `google-services.json` in Android project.
3. Install React Native JS modules as needed.
4. Use `npx react-native run-android` to build and run on Android 15+.

---

## 📱 Frontend

React Native app using Firebase Messaging (`App.js` included).

Install dependencies:

```
npm install @react-native-firebase/app @react-native-firebase/messaging
```

Run the app:

```
npx react-native run-android
```

---

## 🔁 Backend Simulation

Navigate to `backend/` and run:

```
npm install express axios
node index.js
```

Send notification via POST:

```
POST http://localhost:3000/send-notification
{
  "title": "Test Title",
  "body": "This is a test message",
  "token": "DEVICE_FCM_TOKEN"
}
```

Replace `YOUR_SERVER_KEY` in `index.js` with your Firebase server key.

