package com.park.mapper;

import com.park.pojo.ParkTable;
import com.park.pojo.ParkTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkTableMapper {
    int countByExample(ParkTableExample example);

    int deleteByExample(ParkTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkTable record);

    int insertSelective(ParkTable record);

    List<ParkTable> selectByExample(ParkTableExample example);

    ParkTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParkTable record, @Param("example") ParkTableExample example);

    int updateByExample(@Param("record") ParkTable record, @Param("example") ParkTableExample example);

    int updateByPrimaryKeySelective(ParkTable record);

    int updateByPrimaryKey(ParkTable record);
}