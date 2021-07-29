package com.park.mapper;

import com.park.pojo.AdminTable;
import com.park.pojo.AdminTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminTableMapper {
    int countByExample(AdminTableExample example);

    int deleteByExample(AdminTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminTable record);

    int insertSelective(AdminTable record);

    List<AdminTable> selectByExample(AdminTableExample example);

    AdminTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminTable record, @Param("example") AdminTableExample example);

    int updateByExample(@Param("record") AdminTable record, @Param("example") AdminTableExample example);

    int updateByPrimaryKeySelective(AdminTable record);

    int updateByPrimaryKey(AdminTable record);
}