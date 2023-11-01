package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.MailingRequest;
import com.peaksoft.gadgetaruimm6.model.dto.SubscribeRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mailing/")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MailingController {


    @PostMapping("/follow")
    public String crateNew(@RequestBody SubscribeRequest subscribeRequest) {
        return null;
    }

    @PostMapping("/mail-to")
    public String mailingToUser(@RequestBody MailingRequest mailingRequest) {
        return null;
    }

}