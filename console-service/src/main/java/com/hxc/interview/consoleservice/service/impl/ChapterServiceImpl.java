package com.hxc.interview.consoleservice.service.impl;

import com.hxc.interView.common.entity.Chapter;
import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interview.consoleservice.dao.ChapterMapper;
import com.hxc.interview.consoleservice.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public ServiceResult getAllChapters() {
        List<Chapter> chapterList = chapterMapper.getAllChapters();
        return ServiceResult.success(200, "查询成功", chapterList);
    }
}
