package com.hxc.interview.paperservice.controller;

import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.paperservice.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping("/getPaper")
    public ServiceResult getPaper() {
        return null;
    }

}
