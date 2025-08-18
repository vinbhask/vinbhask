package library;

import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class EmailExecutionReport {
	 static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
     static Date date = new Date();

	 static String attachFiles="C:\\Users\\vinbhask\\Desktop\\Environment_Validations_Results.xls";
	 //static String messageToBeSent="<body > <p><font face="+"calibri"+">Hi All,</font></p><p><font face="+"calibri"+">Please find the Environment validations report as in the attached file</font></p><p><font face="+"calibri"+">This set of execution was completed on: "+dateFormat.format(date)+"</font></p><p><font face="+"calibri"+">Brief summary as below:<br><img src=\"cid:image1\" /></font></p><font face="+"calibri"+">Regards<br><font face="+"calibri"+">Sumanth<br><br>---This is a auto generated email---</body>";
	 @Test
    public  void JavaSentEamil() throws Exception {
       // String host="host";

		  /*Capture screen shot of summary*/
 	/*	  Desktop dk = null;
 		  dk = Desktop.getDesktop();
 		  dk.open(new File(UtilLib.getEnvVar("EnvironmentValidationReport")));
       	  UtilLib.WaitTime(3000);
           Robot robot = new Robot();
           String format = "jpg";
           String fileName = "Summary." + format;
           Rectangle captureRect = new Rectangle(85,232, 758,528);
           BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
           ImageIO.write(screenFullImage, format, new File(fileName));*/




		 final String user="vinod@email.com";

	        String to="vinod@email.com";

	        //Get the session object
	        Properties props = new Properties();
	        props.put("mail.smtp.host",UtilLib.getEnvVar("OutlookServer"));
	        props.put("mail.smtp.auth", "false");
	        Session session=Session.getDefaultInstance(props, null);
	        session.setDebug(true);

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.saveChanges();
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Automation Environment validations Report as on: "+dateFormat.format(date));
                    // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            //messageBodyPart.setContent(messageToBeSent, "text/html ; charset=ISO-8859-1");

            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds attachments
            if (attachFiles != null) {
                                  MimeBodyPart attachPart = new MimeBodyPart();
                             attachPart.attachFile(attachFiles);
                        multipart.addBodyPart(attachPart);
                    }

            /* Inline image*/
            Map<String, String> inlineImages = new HashMap<String, String>();
            inlineImages.put("image1", UtilLib.getEnvVar("SummaryImage"));
            // adds inline image attachments
            if (inlineImages != null && inlineImages.size() > 0) {
                Set<String> setImageID = inlineImages.keySet();

                for (String contentId : setImageID) {
                    MimeBodyPart imagePart = new MimeBodyPart();
                    imagePart.setHeader("Content-ID", "<" + contentId + ">");
                    imagePart.setDisposition(MimeBodyPart.INLINE);
                    String imageFilePath = inlineImages.get(contentId);
                    try {
                        imagePart.attachFile(imageFilePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                	}
            		}
            //StringBuffer htmlBody = new StringBuffer("<html><body><p><font face="+"calibri"+">Hi All,</font></p><p><font face="+"calibri"+">Please find the Environment validations report as in the attached file</font></p><p><font face="+"calibri"+">This set of execution was completed on: "+dateFormat.format(date)+"</font></p>");
            //htmlBody.append("Brief summary as below:<br>");
            //htmlBody.append("<img src=\"cid:image1\"  /><br>");
            //htmlBody.toString();

            String messageToBeSent="<body > <p><font face="+"calibri"+">Hi All,</font></p><p><font face="+"calibri"+">Please find the Environment validations report as in the attached file</font></p><p><font face="+"calibri"+">This set of execution was completed on: "+dateFormat.format(date)+"</font></p><p><font face="+"calibri"+">Brief summary as below:<br><img src=\"cid:image1\" /></font></p><font face="+"calibri"+">Regards<br><font face="+"calibri"+">Sumanth<br><br>---This is a auto generated email---</body>";
            messageBodyPart.setContent(messageToBeSent, "text/html");

             // sets the multi-part as e-mail's content
            message.setContent(multipart);

            //send the message
            Transport.send(message);

            System.out.println("Message sent successfully...");
        }
        catch (MessagingException e) {e.printStackTrace();}

    }
}
