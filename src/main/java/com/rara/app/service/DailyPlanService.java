package com.rara.app.service;

import com.rara.app.dto.DailyPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DailyPlanService {

    void insertDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception;

    void deleteDailyPlan(Long id) throws Exception;

    void updateDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception;

    void updateDailyPlanSetYear(Long id, Long year) throws Exception;

    void updateDailyPlanSetMonth(Long id, Long month) throws Exception;

    void updateDailyPlanSetDay(Long id, Long day) throws Exception;

    void updateDailyPlanSetKey1(Long id, String key1) throws Exception;

    void updateDailyPlanSetKey2(Long id, String key2) throws Exception;

    void updateDailyPlanSetKey3(Long id, String key3) throws Exception;

    void updateDailyPlanSetFile1(Long id, String file1) throws Exception;

    void updateDailyPlanSetFile2(Long id, String file2) throws Exception;

    void updateDailyPlanSetMId(Long id, Long mId) throws Exception;

    void updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception;

    void updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception;

    List<DailyPlanDTO> selectDailyPlansAll() throws Exception;

    DailyPlanDTO selectDailyPlanById(Long id) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYear(Long year) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMonth(Long month) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByDay(Long day) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYearAndMonth(Long year, Long month) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYearAndMonthAndDay(Long year, Long month, Long day) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByFile1(String file1) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByFile2(String file2) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMId(Long mId) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndYear(Long mId, Long year) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndActTitle(Long mId, String actTitle) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndActType(Long mId, String actType) throws Exception;
    
}
