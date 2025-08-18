package library;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendExecutionReportThroughEmail {
	 static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
     static Date date = new Date();
  @Test
  @Parameters({"EmailId"})
  public static void sendExecutionReport(String EmailId)
              throws AddressException, MessagingException, IOException {
	  String htmlBody="<body > <p><font face="+"calibri"+">Hi All,</font></p><p><font face="+"calibri"+">Please find the Environment validations report as in the attached file</font></p><p><font face="+"calibri"+">This set of execution was completed on: "+dateFormat.format(date)+"</font></p><p><font face="+"calibri"+"><font face="+"calibri"+">Regards<br><font face="+"calibri"+">V<br><br>---This is a auto generated email---</body>";
	  String attachFiles=UtilLib.getEnvVar("ExcelReportsPath");
	  //System.out.println("Sending email to: "+EmailId);
      // sets SMTP server properties

	  try{
	  Properties props = new Properties();
	  props.put("mail.smtp.host",UtilLib.getEnvVar("OutlookServer"));
      props.put("mail.smtp.auth", "false");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.port", "25");
      Session session=Session.getDefaultInstance(props, null);
      session.setDebug(true);
      final String user=UtilLib.getEnvVar("ExecutionEmailFrom");

      //String to=UtilLib.getEnvVar("ExecutionEmailTo");
      String to=EmailId;
      MimeMessage message = new MimeMessage(session);
      message.saveChanges();
      message.setFrom(new InternetAddress(user));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject("Test Automation - Environment validations Report as on: "+dateFormat.format(date));
              // creates message part
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(htmlBody, "text/html");

      // creates multi-part
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      // adds attachments
      if (attachFiles != null) {
                            MimeBodyPart attachPart = new MimeBodyPart();
                       attachPart.attachFile(attachFiles);
                  multipart.addBodyPart(attachPart);
              }



      message.setContent(multipart);

      Transport.send(message);
	  }
	  catch (Exception e){
		  System.out.println(e);
	  }
  }
}
