package mamikost.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@Component
@Configurable
public class MailNotificationUtils {

    @Autowired
    private JavaMailSender mailSender;

    public void sendGmailEmailReport() throws IOException, MessagingException {
        String toEmail = "reinnatan@gmail.com";
        String fromEmail = "reinnatanbackup@gmail.com";
        String subject = "Coba Baru";
        MimeMessage message = mailSender.createMimeMessage();

        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");
        message.setFrom(new InternetAddress(fromEmail));
        message.setReplyTo(InternetAddress.parse(toEmail, false));
        message.setSubject(subject, "UTF-8");
        message.setSentDate(new Date());
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

        byte[] bytes = Files.readAllBytes(Paths.get("result/android.html"));
        String fileContent = new String (bytes);

        // Create the message body part
        BodyPart messageBodyPart = new MimeBodyPart();
        // Fill the message
        messageBodyPart.setText(fileContent);

        // Create a multipart message for attachment
        Multipart multipart = new MimeMultipart();
        // Set text message part

        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);

        mailSender.send(message);
        System.out.println("Mail send successfully...");
    }
}
