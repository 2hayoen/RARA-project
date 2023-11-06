package com.rara.app.service;

import com.rara.app.dto.DailyRecordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DailyRecordService {

    void insertDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception;

    void deleteDailyRecord(Long id) throws Exception;

    void updateDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception;

    void updateDailyRecordSetTitle(Long id, String title) throws Exception;

    void updateDailyRecordSetContent(Long id, String content) throws Exception;

    void updateDailyRecordSetFile1(Long id, String file1) throws Exception;

    void updateDailyRecordSetFile2(Long id, String file2) throws Exception;

    void updateDailyRecordSetAct1Rec(Long id, String act1Rec) throws Exception;

    void updateDailyRecordSetAct2Rec(Long id, String act2Rec) throws Exception;

    void updateDailyRecordSetCId(Long id, Long cId) throws Exception;

    void updateDailyRecordSetDpId(Long id, Long dpId) throws Exception;

    List<DailyRecordDTO> selectDailyRecordsAll() throws Exception;

    DailyRecordDTO selectDailyRecordById(Long id) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByTitle(String title) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByContent(String content) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByCId(Long cId) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByDpId(Long dpId) throws Exception;

}
