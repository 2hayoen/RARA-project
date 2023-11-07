package com.rara.app.service;

import com.rara.app.dto.DailyRecordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DailyRecordService {

    void insertDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception;

    void deleteDailyRecord(long id) throws Exception;

    void updateDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception;

    void updateDailyRecordSetTitle(long id, String title) throws Exception;

    void updateDailyRecordSetContent(long id, String content) throws Exception;

    void updateDailyRecordSetFile1(long id, String file1) throws Exception;

    void updateDailyRecordSetFile2(long id, String file2) throws Exception;

    void updateDailyRecordSetAct1Rec(long id, String act1Rec) throws Exception;

    void updateDailyRecordSetAct2Rec(long id, String act2Rec) throws Exception;

    void updateDailyRecordSetCId(long id, long cId) throws Exception;

    void updateDailyRecordSetDpId(long id, long dpId) throws Exception;

    List<DailyRecordDTO> selectDailyRecordsAll() throws Exception;

    DailyRecordDTO selectDailyRecordById(long id) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByTitle(String title) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByContent(String content) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByCId(long cId) throws Exception;

    List<DailyRecordDTO> selectDailyRecordByDpId(long dpId) throws Exception;

}
