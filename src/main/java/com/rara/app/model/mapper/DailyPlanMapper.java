package com.rara.app.model.mapper;

import com.rara.app.dto.DailyPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface DailyPlanMapper {

    void insertDailyPlan(DailyPlanDTO dailyPlanDTO);

    void deleteDailyPlan(@Param("id") Long id);

    void updateDailyPlanSetYearOrMonthOrKey1OrKey2OrKey3(
            Map<String, Object> params);

    void updateDailyPlanSetDayOrFile1OrFile2OrMId(
            Map<String, Object> params);

    void updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params);

    void updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params);

    void selectDailyPlansAll(Map<String, Object> params);

    void selectDailyPlanById(Map<String, Object> params);

    void selectDailyPlanByMonth(Map<String, Object> params);

    void selectDailyPlanByDay(Map<String, Object> params);

    void selectDailyPlanByFile1(Map<String, Object> params);

    void selectDailyPlanByFile2(Map<String, Object> params);

    void selectDailyPlanByYearAndMonthOrDay(Map<String, Object> params);

    void selectDailyPlanByMIdAndYearOrActTitleOrActType(Map<String, Object> params);
}
