package com.rara.app.service;

import com.rara.app.dto.DailyPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DailyPlanService {

    void insertDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception;

    void deleteDailyPlan(long id) throws Exception;

    void updateDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception;

    void updateDailyPlanSetYear(long id, long year) throws Exception;

    void updateDailyPlanSetMonth(long id, long month) throws Exception;

    void updateDailyPlanSetDay(long id, long day) throws Exception;

    void updateDailyPlanSetKey1(long id, String key1) throws Exception;

    void updateDailyPlanSetKey2(long id, String key2) throws Exception;

    void updateDailyPlanSetKey3(long id, String key3) throws Exception;

    void updateDailyPlanSetFile1(long id, String file1) throws Exception;

    void updateDailyPlanSetFile2(long id, String file2) throws Exception;

    void updateDailyPlanSetMId(long id, long mId) throws Exception;

    void updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception;

    void updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception;

    List<DailyPlanDTO> selectDailyPlansAll() throws Exception;

    DailyPlanDTO selectDailyPlanById(long id) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYear(long year) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMonth(long month) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByDay(long day) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYearAndMonth(long year, long month) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYearAndMonthAndDay(long year, long month, long day) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByFile1(String file1) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByFile2(String file2) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMId(long mId) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndYear(long mId, long year) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndActTitle(long mId, String actTitle) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndActType(long mId, String actType) throws Exception;

}
