package com.hxc.interview.paperservice.dao;

import com.hxc.interView.common.entity.Major;
import com.hxc.interView.common.result.ServiceResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MajorMapper {
    ArrayList<Major> getAllMajors();
}
