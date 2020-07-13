package com.cderian.petagram.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SessionMail extends AsyncTask<Void, Void, Void> {

    private TextView etPara,etAsunto,etMensaje;
    public static final String USER = "";
    public static final String PASS = "";

    //Declaring Variables
    private Context context;
    private Session session;

    //Information to send email
    private String email;
    private String mensaje;

    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;

    public SessionMail(Context context, String email, String mensaje) {
        this.context = context;
        this.email = email;
        this.mensaje = mensaje;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"Send MSG","Sending message",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        Toast.makeText(context,"Email Enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            //autenticar password
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(USER, PASS);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.setFrom(new InternetAddress(USER));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(this.email));
            mimeMessage.setSubject("Petagram Message");
            mimeMessage.setText(this.mensaje);

            Transport.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
