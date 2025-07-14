import React, { useEffect } from 'react';
import { View, Text, Alert } from 'react-native';
import messaging from '@react-native-firebase/messaging';

const App = () => {
  useEffect(() => {
    const unsubscribe = messaging().onMessage(async remoteMessage => {
      Alert.alert(remoteMessage.notification.title, remoteMessage.notification.body);
    });

    messaging().setBackgroundMessageHandler(async remoteMessage => {
      console.log('Message handled in the background!', remoteMessage);
    });

    return unsubscribe;
  }, []);

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text>React Native Firebase Push App</Text>
    </View>
  );
};

export default App;