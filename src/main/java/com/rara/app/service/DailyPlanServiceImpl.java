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
    public void updateDailyPlan(DailyPlanDTO dailyPlanDTO) throws Exception {
        dailyPlanMapper.updateDailyPlan(dailyPlanDTO);
    }

    ;

    @Override
    public void updateDailyPlanSetYear(Long id, Long year) throws Exception {
        dailyPlanMapper.updateDailyPlanSetYear(id, year);
    }

    @Override
    public void updateDailyPlanSetMonth(Long id, Long month) throws Exception {
        dailyPlanMapper.updateDailyPlanSetMonth(id, month);
    }

    @Override
    public void updateDailyPlanSetDay(Long id, Long day) throws Exception {
        dailyPlanMapper.updateDailyPlanSetDay(id, day);
    }

    @Override
    public void updateDailyPlanSetKey1(Long id, String key1) throws Exception {
        dailyPlanMapper.updateDailyPlanSetKey1(id, key1);
    }

    @Override
    public void updateDailyPlanSetKey2(Long id, String key2) throws Exception {
        dailyPlanMapper.updateDailyPlanSetKey2(id, key2);
    }

    @Override
    public void updateDailyPlanSetKey3(Long id, String key3) throws Exception {
        dailyPlanMapper.updateDailyPlanSetKey3(id, key3);
    }

    @Override
    public void updateDailyPlanSetFile1(Long id, String file1) throws Exception {
        dailyPlanMapper.updateDailyPlanSetFile1(id, file1);
    }

    @Override
    public void updateDailyPlanSetFile2(Long id, String file2) throws Exception {
        dailyPlanMapper.updateDailyPlanSetFile2(id, file2);
    }

    @Override
    public void updateDailyPlanSetMId(Long id, Long mId) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByYear(Long year) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByYearAndMonth(Long year, Long month) throws Exception {
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
            Long year, Long month, Long day) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByMId(Long mId) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByMIdAndYear(Long mId, Long year) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByMIdAndActTitle(Long mId, String actTitle) throws Exception {
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
    public List<DailyPlanDTO> selectDailyPlanByMIdAndActType(Long mId, String actType) throws Exception {
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
