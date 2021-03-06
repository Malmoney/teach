package com.liurq.student.modules.files.mapper;

import com.liurq.student.modules.files.model.File;
import com.liurq.student.modules.files.model.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int countByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int deleteByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int insert(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int insertSelective(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    List<File> selectByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    File selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int updateByPrimaryKeySelective(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated Mon Sep 20 13:18:35 CST 2021
     */
    int updateByPrimaryKey(File record);

    /**
     * ??????recordid??????????????????
     * @param recordId
     * @return
     */
    List<File> selectListByRecordId(@Param("recordId") String recordId,@Param("urlPrefix") String urlPrefix);
}