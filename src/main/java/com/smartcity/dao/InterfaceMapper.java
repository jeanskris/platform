package com.smartcity.dao;

import com.smartcity.models.Interface;
import com.smartcity.models.InterfaceKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InterfaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interface
     *
     * @mbggenerated
     */
    @Delete({
        "delete from interface",
        "where InterfaceID = #{interfaceid,jdbcType=INTEGER}",
          "and APPID = #{appid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(InterfaceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interface
     *
     * @mbggenerated
     */
    @Insert({
        "insert into interface (InterfaceID, APPID, ",
        "DataAddr, Method, ",
        "Parameters)",
        "values (#{interfaceid,jdbcType=INTEGER}, #{appid,jdbcType=INTEGER}, ",
        "#{dataaddr,jdbcType=VARCHAR}, #{method,jdbcType=VARCHAR}, ",
        "#{parameters,jdbcType=VARCHAR})"
    })
    int insert(Interface record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interface
     *
     * @mbggenerated
     */
    int insertSelective(Interface record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interface
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "InterfaceID, APPID, DataAddr, Method, Parameters",
        "from interface",
        "where InterfaceID = #{interfaceid,jdbcType=INTEGER}",
          "and APPID = #{appid,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Interface selectByPrimaryKey(InterfaceKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interface
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Interface record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table interface
     *
     * @mbggenerated
     */
    @Update({
        "update interface",
        "set DataAddr = #{dataaddr,jdbcType=VARCHAR},",
          "Method = #{method,jdbcType=VARCHAR},",
          "Parameters = #{parameters,jdbcType=VARCHAR}",
        "where InterfaceID = #{interfaceid,jdbcType=INTEGER}",
          "and APPID = #{appid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Interface record);
}