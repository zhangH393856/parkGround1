package com.park.mapper;

import com.park.pojo.ParkuserTable;
import com.park.pojo.ParkuserTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkuserTableMapper {
    int countByExample(ParkuserTableExample example);

    int deleteByExample(ParkuserTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkuserTable record);

    int insertSelective(ParkuserTable record);

    List<ParkuserTable> selectByExample(ParkuserTableExample example);

    ParkuserTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParkuserTable record, @Param("example") ParkuserTableExample example);

    int updateByExample(@Param("record") ParkuserTable record, @Param("example") ParkuserTableExample example);

    int updateByPrimaryKeySelective(ParkuserTable record);

    int updateByPrimaryKey(ParkuserTable record);
}