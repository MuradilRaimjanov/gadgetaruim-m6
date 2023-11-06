package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.MainPageResponse;
import com.peaksoft.gadgetaruimm6.service.impl.MainPageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class MainPageController {

    MainPageService mainPageService;

    @GetMapping("/getMain")
    public MainPageResponse mainPageResponse() {
        return mainPageService.mainPage();
    }


}
