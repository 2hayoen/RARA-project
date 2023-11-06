package com.rara.app.model.mapper;

import com.rara.app.dto.DailyRecordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface DailyRecordMapper {

    void insertDailyRecord(DailyRecordDTO dailyRecordDTO);

    void deleteDailyRecord(@Param("id") Long id);

    void updateDailyRecord(DailyRecordDTO dailyRecordDTO);

    void updateDailyRecordSetTitle(@Param("id") Long id, @Param("title") String title);

    void updateDailyRecordSetContent(@Param("id") Long id, @Param("content") String content);

    void updateDailyRecordSetFile1(@Param("id") Long id, @Param("file1") String file1);

    void updateDailyRecordSetFile2(@Param("id") Long id, @Param("file2") String file2);

    void updateDailyRecordSetAct1Rec(@Param("id") Long id, @Param("act1Rec") String act1Rec);

    void updateDailyRecordSetAct2Rec(@Param("id") Long id, @Param("act2Rec") String act2Rec);

    void updateDailyRecordSetCId(@Param("id") Long id, @Param("cId") Long cId);

    void updateDailyRecordSetDpId(@Param("id") Long id, @Param("dpId") Long dpId);

    void selectDailyRecordsAll(Map<String, Object> params);

    void selectDailyRecordById(Map<String, Object> params);

    void selectDailyRecordByTitle(Map<String, Object> params);

    void selectDailyRecordByContent(Map<String, Object> params);

    void selectDailyRecordByCId(Map<String, Object> params);

    void selectDailyRecordByDpId(Map<String, Object> params);

}
