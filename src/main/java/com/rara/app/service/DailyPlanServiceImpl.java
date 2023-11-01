package com.rara.app.service;

import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.model.mapper.DailyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DailyPlanServiceImpl implements DailyPlanService {

    @Autowired
    DailyPlanMapper dailyPlanMapper;

    @Override
    public void insertDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception {
        dailyPlanMapper.insertDailyPlan(dailyPlanDTO);
    }

    @Override
    public void deleteDailyPlan(Long id) throws Exception {
        dailyPlanMapper.deleteDailyPlan(id);
    }

    @Override
    public void updateDailyPlanSetYearOrMonthOrKey1OrKey2OrKey3(
            Map<String, Object> params) throws Exception {
        dailyPlanMapper.updateDailyPlanSetYearOrMonthOrKey1OrKey2OrKey3(params);
    }

    @Override
    public void updateDailyPlanSetDayOrFile1OrFile2OrMId(
            Map<String, Object> params) throws Exception {
        dailyPlanMapper.updateDailyPlanSetDayOrFile1OrFile2OrMId(params);
    }

    @Override
    public void updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception {
        dailyPlanMapper
                .updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(params);
    }

    @Override
    public void updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(
            Map<String, Object> params) throws Exception {
        dailyPlanMapper
                .updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(params);
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlansAll() throws Exception {
        Map<String, Object> params = new HashMap<>();
        dailyPlanMapper.selectDailyPlansAll(params);
        return (List<DailyPlanDTO>) params.get("cursor");
    }

    @Override
    public DailyPlanDTO selectDailyPlanById(Long id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        dailyPlanMapper.selectDailyPlanById(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByMonth(Long month) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("month", month);
        dailyPlanMapper.selectDailyPlanByMonth(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByDay(Long day) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("day", day);
        dailyPlanMapper.selectDailyPlanByDay(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByFile1(String file1) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("file1", file1);
        dailyPlanMapper.selectDailyPlanByFile1(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByFile2(String file2) throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("file2", file2);
        dailyPlanMapper.selectDailyPlanByFile2(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByYearOrMonthOrDay(
            Map<String, Object> params) throws Exception {

        dailyPlanMapper.selectDailyPlanByYearOrMonthOrDay(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByMIdOrYearOrActTitleOrActType(
            Map<String, Object> params) throws Exception {

        dailyPlanMapper.selectDailyPlanByMIdOrYearOrActTitleOrActType(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }
}
