package com.hxc.interview.consoleservice.dao;

import com.hxc.interView.common.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterMapper {
    List<Chapter> getAllChapters();
}
