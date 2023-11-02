package com.rara.app.service;

import com.rara.app.dto.DailyPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DailyPlanService {

    void insertDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception;

    void deleteDailyPlan(Long id) throws Exception;

    void updateDailyPlanSetYearOrMonthOrKey1OrKey2OrKey3(
            Map<String, Object> params) throws Exception;

    void updateDailyPlanSetDayOrFile1OrFile2OrMId(
            Map<String, Object> params) throws Exception;

    void updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception;

    void updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception;

    List<DailyPlanDTO> selectDailyPlansAll() throws Exception;

    DailyPlanDTO selectDailyPlanById(Long id) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMonth(Long month) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByDay(Long day) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByFile1(String file1) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByFile2(String file2) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByYearAndMonthOrDay(
            Map<String, Object> params) throws Exception;

    List<DailyPlanDTO> selectDailyPlanByMIdAndYearOrActTitleOrActType(
            Map<String, Object> params) throws Exception;
}
