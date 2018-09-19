package com.jdmail.mail.mapper;

import com.jdmail.mail.entity.MstDict;

public interface MstDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(MstDict record);

    int insertSelective(MstDict record);

    MstDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MstDict record);

    int updateByPrimaryKey(MstDict record);
}