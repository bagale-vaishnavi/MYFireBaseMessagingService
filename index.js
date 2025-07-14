const express = require('express');
const axios = require('axios');
const app = express();

app.use(express.json());

app.post('/send-notification', async (req, res) => {
  const { title, body, token } = req.body;

  const payload = {
    to: token,
    notification: {
      title,
      body,
      sound: 'default'
    }
  };

  try {
    const response = await axios.post(
      'https://fcm.googleapis.com/fcm/send',
      payload,
      {
        headers: {
          Authorization: 'key=YOUR_SERVER_KEY',
          'Content-Type': 'application/json',
        }
      }
    );
    res.status(200).send(response.data);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

app.listen(3000, () => console.log('Backend server running on port 3000'));