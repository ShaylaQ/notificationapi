package Controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
@Component
public class FirebaseInitializer {
    @PostConstruct
    public void init() {
        try {
            FileInputStream serviceAccount =
                    new
                            FileInputStream("src/main/resources/opsc-84508-firebase-adminsdk-fbsvc-1843e2059a.json");
                            FirebaseOptions options = FirebaseOptions.builder()

                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            System.out.println("Firebase has been initialized!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
