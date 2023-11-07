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
    public void deleteDailyPlan(long id) throws Exception {
        dailyPlanMapper.deleteDailyPlan(id);
    }

    @Override
    public void updateDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception {
        dailyPlanMapper.updateDailyPlan(dailyPlanDTO);
    }

    ;

    @Override
    public void updateDailyPlanSetYear(long id, long year) throws Exception {
        dailyPlanMapper.updateDailyPlanSetYear(id, year);
    }

    @Override
    public void updateDailyPlanSetMonth(long id, long month) throws Exception {
        dailyPlanMapper.updateDailyPlanSetMonth(id, month);
    }

    @Override
    public void updateDailyPlanSetDay(long id, long day) throws Exception {
        dailyPlanMapper.updateDailyPlanSetDay(id, day);
    }

    @Override
    public void updateDailyPlanSetKey1(long id, String key1) throws Exception {
        dailyPlanMapper.updateDailyPlanSetKey1(id, key1);
    }

    @Override
    public void updateDailyPlanSetKey2(long id, String key2) throws Exception {
        dailyPlanMapper.updateDailyPlanSetKey2(id, key2);
    }

    @Override
    public void updateDailyPlanSetKey3(long id, String key3) throws Exception {
        dailyPlanMapper.updateDailyPlanSetKey3(id, key3);
    }

    @Override
    public void updateDailyPlanSetFile1(long id, String file1) throws Exception {
        dailyPlanMapper.updateDailyPlanSetFile1(id, file1);
    }

    @Override
    public void updateDailyPlanSetFile2(long id, String file2) throws Exception {
        dailyPlanMapper.updateDailyPlanSetFile2(id, file2);
    }

    @Override
    public void updateDailyPlanSetMId(long id, long mId) throws Exception {
        dailyPlanMapper.updateDailyPlanSetMId(id, mId);
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
    public DailyPlanDTO selectDailyPlanById(long id) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByYear(long year) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        dailyPlanMapper.selectDailyPlanByYear(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByMonth(long month) throws Exception {

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
    public List<DailyPlanDTO> selectDailyPlanByDay(long day) throws Exception {

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
    public List<DailyPlanDTO> selectDailyPlanByYearAndMonth(long year, long month) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        dailyPlanMapper.selectDailyPlanByYearAndMonth(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByYearAndMonthAndDay(
            long year, long month, long day) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        params.put("day", day);
        dailyPlanMapper.selectDailyPlanByYearAndMonthAndDay(params);

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
    public List<DailyPlanDTO> selectDailyPlanByMId(long mId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("mId", mId);
        dailyPlanMapper.selectDailyPlanByMId(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByMIdAndYear(long mId, long year) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("mId", mId);
        params.put("year", year);
        dailyPlanMapper.selectDailyPlanByMIdAndYear(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByMIdAndActTitle(long mId, String actTitle) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("mId", mId);
        params.put("actTitle", actTitle);
        dailyPlanMapper.selectDailyPlanByMIdAndActTitle(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyPlanDTO> selectDailyPlanByMIdAndActType(long mId, String actType) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("mId", mId);
        params.put("actType", actType);
        dailyPlanMapper.selectDailyPlanByMIdAndActType(params);

        List<DailyPlanDTO> results = (List<DailyPlanDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }
}
