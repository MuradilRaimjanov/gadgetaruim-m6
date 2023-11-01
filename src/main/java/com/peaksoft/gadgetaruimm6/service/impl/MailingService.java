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
            System.out.println(user.getFollowToMailing());
            if (user.getFollowToMailing()) {
                message.setFrom("temuchi500@gmail.com");
                message.setTo(user.getEmail());
                message.setSubject(mailingRequest.getName());
                message.setText(mailingRequest.getImage()+"\n"+mailingRequest.getDescription()+"\nStart sale "+mailingRequest.getStart()+"\nEnd sale "+ mailingRequest.getEnd());
                mailSender.send(message);
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

}
