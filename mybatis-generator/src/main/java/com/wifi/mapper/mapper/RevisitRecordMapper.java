package com.wifi.mapper.mapper;

import com.wifi.model.model.RevisitRecord;

public interface RevisitRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RevisitRecord record);

    int insertSelective(RevisitRecord record);

    RevisitRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RevisitRecord record);

    int updateByPrimaryKey(RevisitRecord record);
}