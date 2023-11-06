package com.rara.app.model.mapper;

import com.rara.app.dto.DailyPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface DailyPlanMapper {

    void insertDailyPlan(DailyPlanDTO dailyPlanDTO);

    void deleteDailyPlan(@Param("id") Long id);

    void updateDailyPlan(DailyPlanDTO dailyPlanDTO);

    void updateDailyPlanSetYear(@Param("id") Long id, @Param("year") Long year);

    void updateDailyPlanSetMonth(@Param("id") Long id, @Param("month") Long month);

    void updateDailyPlanSetDay(@Param("id") Long id, @Param("day") Long day);

    void updateDailyPlanSetKey1(@Param("id") Long id, @Param("key1") String key1);

    void updateDailyPlanSetKey2(@Param("id") Long id, @Param("key2") String key2);

    void updateDailyPlanSetKey3(@Param("id") Long id, @Param("key3") String key3);

    void updateDailyPlanSetFile1(@Param("id") Long id, @Param("file1") String file1);

    void updateDailyPlanSetFile2(@Param("id") Long id, @Param("file2") String file2);

    void updateDailyPlanSetMId(@Param("id") Long id, @Param("mId") Long mId);

    void updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params);

    void updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params);

    void selectDailyPlansAll(Map<String, Object> params);

    void selectDailyPlanById(Map<String, Object> params);

    void selectDailyPlanByYear(Map<String, Object> params);

    void selectDailyPlanByMonth(Map<String, Object> params);

    void selectDailyPlanByDay(Map<String, Object> params);

    void selectDailyPlanByYearAndMonth(Map<String, Object> params);

    void selectDailyPlanByYearAndMonthAndDay(Map<String, Object> params);

    void selectDailyPlanByFile1(Map<String, Object> params);

    void selectDailyPlanByFile2(Map<String, Object> params);

    void selectDailyPlanByMId(Map<String, Object> params);

    void selectDailyPlanByMIdAndYear(Map<String, Object> params);

    void selectDailyPlanByMIdAndActTitle(Map<String, Object> params);

    void selectDailyPlanByMIdAndActType(Map<String, Object> params);
}
