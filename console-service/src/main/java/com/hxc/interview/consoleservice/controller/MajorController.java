package com.hxc.interview.consoleservice.controller;

import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.consoleservice.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MajorController {

    @Resource
    private MajorService majorService;

    /**
     * 拿到所有的专业
     * @return
     */
    @GetMapping("/getAllMajors")
    public ServiceResult getAllMajors() {
        return majorService.getAllMajors();
    }

}
