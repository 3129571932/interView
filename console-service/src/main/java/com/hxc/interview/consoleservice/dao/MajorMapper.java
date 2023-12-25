package com.hxc.interview.consoleservice.dao;

import com.hxc.interView.common.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MajorMapper {
    ArrayList<Major> getAllMajors();
}
