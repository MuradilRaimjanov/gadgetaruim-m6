package com.peaksoft.gadgetaruimm6.service;


public interface EmailService {

    void sendCodeByMail(String to, String otp);
}
