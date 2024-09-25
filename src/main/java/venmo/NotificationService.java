package venmo;

@Service
public class NotificationService {

    public void sendTransactionNotification(String email, String message) {
        // Use SendGrid, SMTP, or other email providers to send notification
    }

    public void sendSmsNotification(String phoneNumber, String message) {
        // Use Twilio or another SMS service
    }
}
