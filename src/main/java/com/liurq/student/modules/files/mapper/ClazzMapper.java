package com.liurq.student.modules.files.mapper;

import com.liurq.student.modules.files.model.Clazz;
import com.liurq.student.modules.files.model.ClazzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClazzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int countByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int deleteByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int insert(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int insertSelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    List<Clazz> selectByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int updateByExampleSelective(@Param("record") Clazz record, @Param("example") ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int updateByExample(@Param("record") Clazz record, @Param("example") ClazzExample example);
}