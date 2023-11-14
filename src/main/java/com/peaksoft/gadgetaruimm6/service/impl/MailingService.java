package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.MailingRequest;
import com.peaksoft.gadgetaruimm6.model.dto.SubscribeRequest;
import com.peaksoft.gadgetaruimm6.model.entity.Mailing;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.repository.MailingRepository;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MailingService {

    JavaMailSender mailSender;
    MailingRepository mailingRepository;
    UserRepository userRepository;

    public String follow(SubscribeRequest subscribeRequest){
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(subscribeRequest.getEmail())) {
                if (user.getFollowToMailing()) {
                    return "You have already subscribed to the newsletter";
                } else {
                    user.setFollowToMailing(true);
                    userRepository.save(user);
                }
            }
        }
        return "You have successfully subscribed";
    }

    public String mailingToUser(MailingRequest mailingRequest) throws NullPointerException {
        List<User> users = userRepository.findAll();
        SimpleMailMessage message = new SimpleMailMessage();
        for (User user : users) {
            if (user.getFollowToMailing()) {
                try {
                    message.setFrom("temuchi500@gmail.com");
                    message.setTo(user.getEmail());
                    message.setSubject(mailingRequest.getName());
                    message.setText(mailingRequest.getImage() + "\n" + mailingRequest.getDescription() + "\nStart sale " + mailingRequest.getStart() + "\nEnd sale " + mailingRequest.getEnd());
                    mailSender.send(message);
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        Mailing mailing = new Mailing();
        mailing.setName(mailingRequest.getName());
        mailing.setDescription(mailingRequest.getDescription());
        mailing.setImage(mailingRequest.getImage());
        mailing.setStartOfSale(mailingRequest.getStart());
        mailing.setEndOfSale(mailingRequest.getEnd());
        mailingRepository.save(mailing);
        return "The mail successfully send to followers";
    }

    public String updateMail(Long id, MailingRequest mailingRequest) {
        Mailing mailingBD = mailingRepository.findById(id).orElseThrow(()-> new RuntimeException("The mailing not found"));
        mailingBD.setName(mailingRequest.getName());
        mailingBD.setDescription(mailingRequest.getDescription());
        mailingBD.setImage(mailingRequest.getImage());
        mailingBD.setStartOfSale(mailingRequest.getStart());
        mailingBD.setEndOfSale(mailingRequest.getEnd());
        mailingRepository.save(mailingBD);
        List<User> users = userRepository.findAll();
        SimpleMailMessage message =new SimpleMailMessage();
        for (User user: users) {
            if (user.getFollowToMailing()) {
                try {
                    message.setFrom("temuchi500@gmail.com");
                    message.setTo(user.getEmail());
                    message.setSubject(mailingRequest.getName());
                    message.setText(mailingRequest.getImage() + "\n" + mailingRequest.getDescription() + "\nStart sale " + mailingRequest.getStart() + "\nEnd sale " + mailingRequest.getEnd());
                    mailSender.send(message);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return "The newsletter has been successfully posted and send";
    }

    public String delete(Long id) {
        Mailing mailing = mailingRepository.findById(id).orElseThrow(()-> new RuntimeException("The mailing not found"));
        mailingRepository.delete(mailing);
        return "The mailing successfully deleted";
    }

}
