package Controller;


import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @PostMapping("/send")
    public String sendNotification(@RequestParam String token,
                                   @RequestParam String title,
                                   @RequestParam String body) {
        try {
            Message message = Message.builder()
                    .setToken(token)
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .build())
                    .build();
            String response =
                    FirebaseMessaging.getInstance().send(message);
            return "Sent successfully: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return " Error sending FCM: " + e.getMessage();
        }
    }
}




