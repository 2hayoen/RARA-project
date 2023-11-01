package com.rara.app.service;

import com.rara.app.dto.DailyRecordDTO;

import java.util.List;
import java.util.Map;

public interface DailyRecordService {

    void insertDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception;

    void deleteDailyRecord(Long id) throws Exception;

    void updateDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception;

    void updateDailyRecordSetTitleOrContentOrFile1OrFile2(
            Map<String, Object> params) throws Exception;

    void updateDailyRecordSetAct1RecOrAct2Rec(
            Map<String, Object> params) throws Exception;

    void updateDailyRecordSetCIdOrDpId(
            Map<String, Object> params) throws Exception;


    List<DailyRecordDTO> selectDailyRecordsAll() throws Exception;

    DailyRecordDTO selectDailyRecordById(Long id) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByTitleOrContent(
            Map<String, Object> params) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByCIdOrDpId(
            Map<String, Object> params) throws Exception;

}
