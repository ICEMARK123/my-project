package com.wifi.mapper.mapper;

import com.wifi.model.model.SearchPeople;

public interface SearchPeopleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchPeople record);

    int insertSelective(SearchPeople record);

    SearchPeople selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchPeople record);

    int updateByPrimaryKey(SearchPeople record);
}