//package com.Lebook.MesferAlQahtani.ServiceImplement;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailServiceImplement {
//
// @Autowired
// public JavaMailSender javaMailSender;
//
//
// public void sendSimpleMessage(String to, String subject, String text){
//     SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//     simpleMailMessage.setTo(to);
//     simpleMailMessage.setSubject(subject);
//     simpleMailMessage.setText(text);
//     javaMailSender.send(simpleMailMessage);
//
//
// }
//}
