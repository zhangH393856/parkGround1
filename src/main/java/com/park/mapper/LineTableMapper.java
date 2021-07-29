package com.park.mapper;

import com.park.pojo.LineTable;
import com.park.pojo.LineTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LineTableMapper {
    int countByExample(LineTableExample example);

    int deleteByExample(LineTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LineTable record);

    int insertSelective(LineTable record);

    List<LineTable> selectByExample(LineTableExample example);

    LineTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LineTable record, @Param("example") LineTableExample example);

    int updateByExample(@Param("record") LineTable record, @Param("example") LineTableExample example);

    int updateByPrimaryKeySelective(LineTable record);

    int updateByPrimaryKey(LineTable record);
}