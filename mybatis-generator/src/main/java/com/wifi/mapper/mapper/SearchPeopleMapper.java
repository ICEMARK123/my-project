package com.wifi.mapper.mapper;

import com.wifi.model.model.SearchPeople;
import com.wifi.model.model.SearchPeopleWithBLOBs;

public interface SearchPeopleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchPeopleWithBLOBs record);

    int insertSelective(SearchPeopleWithBLOBs record);

    SearchPeopleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchPeopleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SearchPeopleWithBLOBs record);

    int updateByPrimaryKey(SearchPeople record);
}