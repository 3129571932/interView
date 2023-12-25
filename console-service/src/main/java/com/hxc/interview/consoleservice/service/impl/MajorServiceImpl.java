package com.hxc.interview.consoleservice.service.impl;

import com.hxc.interView.common.entity.Major;
import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.consoleservice.dao.MajorMapper;
import com.hxc.interview.consoleservice.service.MajorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class MajorServiceImpl implements MajorService {

    @Resource
    private MajorMapper majorMapper;

    @Override
    public ServiceResult getAllMajors() {
        ArrayList<Major> allMajors = majorMapper.getAllMajors();
        return ServiceResult.success(200, "查询成功", allMajors);
    }
}
