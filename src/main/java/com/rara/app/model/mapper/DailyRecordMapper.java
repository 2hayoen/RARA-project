package com.rara.app.model.mapper;

import com.rara.app.dto.DailyRecordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface DailyRecordMapper {

    void insertDailyRecord(DailyRecordDTO dailyRecordDTO);

    void deleteDailyRecord(@Param("id") Long id);

    void updateDailyRecord(DailyRecordDTO dailyRecordDTO);

    void updateDailyRecordSetTitleOrContentOrFile1OrFile2(
            Map<String, Object> params);


    void updateDailyRecordSetAct1RecOrAct2Rec(
            Map<String, Object> params);

    void updateDailyRecordSetCIdOrDpId(
            Map<String, Object> params);

    void selectDailyRecordsAll(Map<String, Object> params);

    void selectDailyRecordById(Map<String, Object> params);

    void selectDailyRecordByTitleOrContent(
            Map<String, Object> params);

    void selectDailyRecordByCIdOrDpId(
            Map<String, Object> params);

}
