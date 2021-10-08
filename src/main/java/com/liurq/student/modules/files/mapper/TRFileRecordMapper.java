package com.liurq.student.modules.files.mapper;

import com.liurq.student.modules.files.model.TRFileRecord;
import com.liurq.student.modules.files.model.TRFileRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRFileRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int countByExample(TRFileRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int deleteByExample(TRFileRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int insert(TRFileRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int insertSelective(TRFileRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    List<TRFileRecord> selectByExample(TRFileRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    TRFileRecord selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int updateByExampleSelective(@Param("record") TRFileRecord record, @Param("example") TRFileRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int updateByExample(@Param("record") TRFileRecord record, @Param("example") TRFileRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int updateByPrimaryKeySelective(TRFileRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_file_record
     *
     * @mbggenerated Mon Sep 20 14:57:26 CST 2021
     */
    int updateByPrimaryKey(TRFileRecord record);
}